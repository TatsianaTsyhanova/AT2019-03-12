package by.it.lugansky.at08;

abstract class Var implements Operation {

   static Var createVar(String strVar){
       //       strVar.matches()
   return null;
   }

    @Override
    public Var add(Var other) {
        System.out.println("Сложение "+this+"+"+other+" невозможно");
        return null;
    }

    @Override
    public Var sub(Var other) {
        System.out.println("Вычитание "+this+"-"+other+" невозможно");
        return null;
        }

    @Override
    public Var mul(Var other) {
        System.out.println("Умножение "+this+"*"+other+" невозможно");
    return null;
    }

    @Override
    public Var div(Var other) {
        System.out.println("Деление "+this+"/"+other+" невозможно");
        return null;
    }

    @Override
   public String toString() {

       return "Это класс AbstractVar";
   }


}
