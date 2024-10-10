package metier;

public class CreditMetierImp implements  ICreditMetier{
    @Override
    public double CalculerMensualiteCredit(double capital,int durre) {
        double taux=0.10;
        double t=taux/100;
        double t2=capital*t/12;
        double t1=1-Math.pow((1+t/12),-durre);
        return t2/t1;
    }

}
