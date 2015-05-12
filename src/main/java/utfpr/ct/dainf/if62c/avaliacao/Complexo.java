package utfpr.ct.dainf.if62c.avaliacao;

/**
 * UTFPR - Universidade Tecnológica Federal do Paraná
 * DAINF - Departamento Acadêmico de Informática
 * IF62C - Fundamentos de Programação 2
 * 
 * Primeira avaliação parcial 2014/2.
 * @author 
 */
public class Complexo {
    private double real;
    private double img;

    public Complexo() {
    }

    public Complexo(double real, double img) {
        this.real = real;
        this.img = img;
    }

    public double getReal() {
        return this.real;
    }
    
    public double getImg() {
        return this.img;
    }

    public Complexo soma(Complexo c) {
        return new Complexo(real + c.real, img + c.img);
    }
    
    public Complexo sub(Complexo c) {
        return new Complexo(real - c.real, img - c.img);
    }
    
    public Complexo prod(double r) {
        return new Complexo(real*r, img*r);
    }

    public Complexo prod(Complexo c) {
        return new Complexo ((real*c.real - img*c.img), (real*c.img + img*c.real));
    }

    public Complexo div(Complexo c) {
        return new Complexo((real*c.real + img*c.img)/(Math.pow(c.img, 2) + 
                Math.pow(c.real, 2)), (c.real*img - real*c.img)/
                (Math.pow(c.img, 2) + Math.pow(c.real, 2)));
        
    }

    public Complexo[] sqrt() {
        Complexo[] vetor = new Complexo[2];
        double fi, ro;
        
        ro = Math.sqrt(Math.sqrt(Math.pow(real, 2) + Math.pow(img, 2)));
        
        if(real > 0)
            fi = Math.atan(img/real);
        else if(real < 0)
            fi = Math.atan(img/real) + Math.PI;
        else if(real == 0 && img == 0)
            fi = 0;
        else if(real == 0 && img > 0)
            fi = Math.PI/2;
        else
            fi = 3*Math.PI/2;
        
        vetor[0] = new Complexo(ro*Math.cos(fi/2),ro*Math.sin(fi/2));
        vetor[1] = new Complexo(ro*Math.cos(fi/2 + Math.PI), ro*Math.sin(fi/2 + Math.PI));
        
        return vetor;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + (int) (Double.doubleToLongBits(real)
            ^ (Double.doubleToLongBits(real) >>> 32));
        hash = 41 * hash + (int) (Double.doubleToLongBits(img)
            ^ (Double.doubleToLongBits(img) >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        final Complexo c = (Complexo) obj;
        return obj != null && getClass() == obj.getClass()
            && real == c.real && img == c.img;
    }

    @Override
    public String toString() {
        return String.format("%+f%+fi", real, img);
    }
}
