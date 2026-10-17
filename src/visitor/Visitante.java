package visitor;

import model.ComputadoraTorre;
import model.Portatil;
import model.Tablet;
import model.Television;

public interface Visitante {
    void visitar(Tablet tablet);
    void visitar(Portatil portatil);
    void visitar(ComputadoraTorre torre);
    void visitar(Television television);
}
