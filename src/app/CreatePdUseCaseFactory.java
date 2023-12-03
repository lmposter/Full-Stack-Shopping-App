package app;

import data_access.ProductDAO;
import interface_adapter.create_product.CreatePdController;
import interface_adapter.create_product.CreatePdPresenter;
import interface_adapter.create_product.CreatePdViewModel;
import interface_adapter.ViewManagerModel;
import use_case.create_product.CreatePdDAI;
import use_case.create_product.CreatePdInputBoundary;
import use_case.create_product.CreatePdInteractor;
import use_case.create_product.CreatePdOutPutBoundary;
import view.CreatePdView;

import javax.swing.*;
import java.io.IOException;

public class CreatePdUseCaseFactory {
    private CreatePdUseCaseFactory(){}

    public static CreatePdView create(
            ViewManagerModel viewManagerModel, CreatePdViewModel createPdViewModel,
            ProductDAO userProductDAO) {

        try{
            CreatePdController createPdController = createPdhUseCase(viewManagerModel, createPdViewModel, userProductDAO);
            return new CreatePdView(createPdController, createPdViewModel);
        } catch (IOException e){
            JOptionPane.showMessageDialog(null, "Could not open product data file.");
        }

        return null;
    }

    private static CreatePdController createPdhUseCase(ViewManagerModel viewManagerModel,
                                                       CreatePdViewModel createPdViewModel, CreatePdDAI userProductDAO)
            throws IOException{
        CreatePdOutPutBoundary createPdPresenter = new CreatePdPresenter(createPdViewModel, viewManagerModel);

        CreatePdInputBoundary createPdInteractor = new CreatePdInteractor(userProductDAO, createPdPresenter);

        return new CreatePdController(createPdInteractor);
    }
}
