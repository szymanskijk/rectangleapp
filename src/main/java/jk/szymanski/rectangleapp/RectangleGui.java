package jk.szymanski.rectangleapp;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.login.AbstractLogin;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

@Route
public class RectangleGui extends VerticalLayout {

    private RectangleRepo rectangleRepo;
    private FigureApi figureApi;
    private TextField textFieldHeigth;
    private TextField textFieldWidth;
    private Button button;
    private Button calculateButton;

    @Autowired
    public RectangleGui(RectangleRepo rectangleRepo) {
        this.rectangleRepo = rectangleRepo;
        textFieldHeigth = new TextField("Podaj wysokość");
        textFieldWidth = new TextField("Podaj szerokość");
        button = new Button("Dodaj!");
        calculateButton = new Button("Oblicz obwód!");

        button.addClickListener(clickEvent -> addRectangle());
        calculateButton.addClickListener((clickEvent -> calculate(Integer.parseInt(textFieldWidth.getValue()),Integer.parseInt(textFieldHeigth.getValue()))));
        add(textFieldHeigth);
        add(textFieldWidth);
        add(button);
        add(calculateButton);
    }
    public void addRectangle(){
        Rectangle rectangle = new Rectangle();
        rectangle.setHeight(Integer.parseInt(textFieldHeigth.getValue()));
        rectangle.setWidth(Integer.parseInt(textFieldWidth.getValue()));
        rectangleRepo.save(rectangle);
    }
    public void calculate(int siteA, int siteB){
        int result = siteA*2 + siteB*2;
        TextField textAns = new TextField("Obwód wynosi: " + result);
        add(textAns);
    }

}
