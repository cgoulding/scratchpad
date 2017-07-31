package app.creator.servlet;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLDecoder;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

public class DownloadServlet extends HttpServlet {
	
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	Map<String, String> fileNames = (Map<String, String>)req.getSession().getAttribute("fileNames");
    	
        String encodedFileName = req.getParameter("fileId");
        String decodedFileName = URLDecoder.decode(encodedFileName, "utf-8");    
        File downloadableFile = new File(fileNames.get(decodedFileName));

        ServletOutputStream os = resp.getOutputStream();
        try {
            InputStream is = FileUtils.openInputStream(downloadableFile);
            try {
                IOUtils.copy(is, os);
            } finally {
                is.close();
            }
        } finally {
            os.close();
        }
    }
}
