import com.sun.tools.javac.Main;


public class AplikasiTodolist {

    public static String[] model = new String[10];

    public static java.util.Scanner scanner = new java.util.Scanner(System.in);

    public static void main(String[] args) {

        testInput();
    }

    /**
     * Menampilkan Todo List
     */
    public static void showTodoList(){
      for (var i = 0; i < model.length; i++){
          var todo = model[i];
          var no = i + 1;

          if( todo != null){
              System.out.println(no + ". " + todo );
          }
      }
    }

    public static void testShowTodoList(){
        model[0] = "ilham";
        model[1] = "alfir";

        showTodoList();
    }


    /**
     * Menambah Todo ke List
     */
    public static void addTodoList(String todo){

        // cek apakah model penuh?
        var isFull = true;
        for ( var i = 0; i < model.length; i++){
            if (model[i] == null){
                // model masih ada yang kosong
                isFull = false;
                break;
            }
        }

        // jika penuh, kita resize ukuran array 2x lipat
        if ( isFull ){
            var temp = model;
            model = new String[model.length * 2];

            for ( var i = 0; i < temp.length; i++){
                model[i] = temp[i];
            }
        }


        // tambahkan ke posisi array yang NULL
        for ( var i = 0; i < model.length; i++){
            if( model[i] == null){
                model[i] = todo;
                break;
            }
        }
    }

    public static void testAddTodoList(){
        for ( var i = 0; i < 25; i++){
            addTodoList("Ini Todolist ke-" + i);
        }
        showTodoList();
    }


    /**
     * Menghapus Todo List
     */
    public static boolean removeTodoList(Integer number) {
        // check jika input number >= model length
        if ( (number - 1) >= model.length){
            return false;
        }else if (model[number - 1] == null){
            return false;
        }else{
            for ( var i = (number - 1); i < model.length; i++){
                if(i == (model.length - 1)) {
                    model[i] = null;
                } else {
                    model[i] = model[i + 1];
                }
            }
            return true;
        }
    }

    public static void testRemoveTodoList(){
        addTodoList("satu");
        addTodoList("dua");
        addTodoList("tiga");
        addTodoList("empat");
        addTodoList("lima");

        var result = removeTodoList(20);
        System.out.println(result);

        result = removeTodoList(7);
        System.out.println(result);

        result = removeTodoList(2);
        System.out.println(result);

        showTodoList();
    }

    public static String input(String info){
        System.out.print(info + " : ");
        String data = scanner.nextLine();
        return data;
    }

    public static void testInput(){
        var name = input("Nama");
        System.out.println("hi " + name);

        var channel = input("channel");
        System.out.println(channel);

    }


    /**
     * Menampilkan view Todo List
     */
    public static void viewShowTodoList(){

    }

    /**
     * Menampilkan view menambahkan Todo List
     */
    public static void viewAddTodoList(){

    }

    /**
     * Menampilkan view menghapus Todo List
     */
    public static void viewRemoveTodoList(){

    }
}
