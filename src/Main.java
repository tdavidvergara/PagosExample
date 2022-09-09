import java.util.Scanner;

public class Main {
    public static Scanner lector = new Scanner (System.in) ;
    public static Tree tree= new Tree() ;
    public static void main(String[] args) {
        boolean flag = false ;
        while (!flag){
            System.out.println("***************************\n" +
                    "Registro DANE\n" +
                    "***************************\n" +
                    "1. Inscribir un ciudadano\n" +
                    "2. Consultar por cédula\n" +
                    "3. Eliminar ciudadano por cédula\n" +
                    "4. Salir\n");
            int option = lector.nextInt() ;
            lector.nextLine()  ;
            switch (option){
                case 1:
                    System.out.println("Enter the id of the citizen");
                    int id = lector.nextInt() ;
                    lector.nextLine() ;
                    System.out.println("Escriba el nombre del ciudadano");
                    String name = lector.nextLine() ;
                    System.out.println("Escriba la fecha de nacimiento del ciudadano:  "+name+" de la siguiente manera: D/M/A");
                    String date = lector.nextLine()  ;
                    System.out.println("Enter the city where the citizen was born");
                    String city = lector.nextLine() ;
                    tree.insert(new Citizen(id,name, date, city)) ;
                    break ;
                case 2:
                    System.out.println("Enter the person you are looking for by its id");
                    int idSearch = lector.nextInt() ;
                    Citizen busqueda=  tree.search(idSearch) ;
                    if(busqueda== null){
                        System.out.println("Citizn not found");
                    }else{
                        System.out.println(
                                "***************************\n" +
                                        "Name: "+ busqueda.getName()+"\n"+
                                        "Birth Date: "+busqueda.getDate()+"\n"+
                                        "Id: "+busqueda.getId()+"\n"+
                                        "City: "+busqueda.getCity()+"\n");


                    }
                    break ;
                case 3:
                    System.out.println("You are about to delete a citizen, are you sure?");
                    String reply = lector.nextLine() ;
                    if(reply.equalsIgnoreCase("si") || reply.equalsIgnoreCase("yes")){
                        System.out.println("Enter the id of the citizen you want to delete: ");
                        int idDelete= lector.nextInt() ;
                        lector.nextLine() ;
                        tree.delete(idDelete) ;

                    }else{
                        System.out.println("Going back to main menu...");

                    }
                    break ;
                case 4:
                    flag = true;
                    break ;



            }

        }

    }
}
