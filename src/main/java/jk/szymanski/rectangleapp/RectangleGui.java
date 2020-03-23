package jk.szymanski.rectangleapp;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

@Route
public class RectangleGui extends VerticalLayout {

    private RectangleRepo rectangleRepo;

    private TextField textFieldHeigth;
    private TextField textFieldWidth;
    private Button button;

    @Autowired
    public RectangleGui(RectangleRepo rectangleRepo) {
        this.rectangleRepo = rectangleRepo;
        textFieldHeigth = new TextField("Podaj wysokość");
        textFieldWidth = new TextField("Podaj szerokość");
        button = new Button("Dodaj!");

        button.addClickListener(clickEvent -> addRectangle());

        add(textFieldHeigth);
        add(textFieldWidth);
        add(button);
    }
    public void addRectangle(){
        Rectangle rectangle = new Rectangle();
        rectangle.setHeight(Integer.parseInt(textFieldHeigth.getValue()));
        rectangle.setWidth(Integer.parseInt(textFieldWidth.getValue()));
        rectangleRepo.save(rectangle);

    }
}
