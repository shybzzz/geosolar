package geosolar.springmvc.service;

import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

@Service
public class FileService {
    public void responseFile(HttpServletResponse response, File file) throws IOException {
        String fileName = file.getName();

        response.setContentType("application/octet-stream");
        response.setHeader(
                "Content-Disposition",
                "inline; filename=\"" + fileName + "\""
        );
        response.setContentLength((int) file.length());
        InputStream inputStream = new FileInputStream(fileName);
        FileCopyUtils.copy(inputStream, response.getOutputStream());
    }
}
