package ${domainPackage}

class ${domainClass} {
	
	<%
	properties.each {
		println "${it.type} ${it.name}"
	}
	%>
	
	static hasOne = [
	<%
	hasOne.eachWithIndex {it, i ->
		if (i > 0) print ", "
		print "${it.name}: ${it.type}"
	}
	%>	
	]
	
	static hasMany = [
	<%
	hasMany.eachWithIndex {it, i ->
		if (i > 0) print ", "
		print "${it.name}: ${it.type}"
	}
	%>	
	]
	
	static belongsTo = [
	<%
	belongsTo.eachWithIndex {it, i ->
		if (i > 0) print ", "
		print "${it}"
	}	
	%>
	]
	
}

