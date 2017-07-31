function makeFrame() {
	var div = window.parent.document.createElement("div");
	div.style.height = "1000px";
	div.style.width = "1000px";
	
	var iframe = window.parent.document.createElement("iframe");
	iframe.style.height = "1000px";
	iframe.style.width = "1000px";
	
	div.appendChild(iframe);
	
	iframe.setAttribute("src", "http://localhost:8080/collab-todo/user/create");
	
	Modalbox.show(div, {title: 'Iframe Modal Box', width: 1000, height: 1000});
}