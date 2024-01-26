package com.project.test.util;



import com.project.test.dto.BlogsDto;
import com.project.test.facade.BlogsFacade;
import com.project.test.facade.ReadersFacade;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.inject.Produces;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author gaes1
 */
@Named
@ViewScoped
public class CombosController implements Serializable {
    
    @Inject
    private BlogsFacade blogsFacade;
    
    @Inject
    private ReadersFacade readersFacade;

    @Produces
    @Named("listBlogs")
    public List<BlogsDto> getBlogs() {
        return blogsFacade.getAll();
    }

   

  

}
