import com.sun.tools.javac.Main;

/**
 * Code By Love @SukaCode
 */

public class AplikasiTodolist {

    public static String[] model = new String[10];

    public static java.util.Scanner scanner = new java.util.Scanner(System.in);

    public static void main(String[] args) {

        viewShowTodoList();
    }

    /**
     * Menampilkan Todo List
     */
    public static void showTodoList(){
        System.out.println("TODO LIST");
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
        while (true){
            showTodoList();

            System.out.println("MENU :");
            System.out.println("1. Tambah");
            System.out.println("2. Hapus");
            System.out.println("3. Keluar");

            var input = input("pilih");
            if (input.equals("1")){
                viewAddTodoList();
            } else if(input.equals("2")){
                viewRemoveTodoList();
            } else if(input.equals("3")){
                break;
            } else {
                System.out.println("Pilihan tidak mengerti");
            }
        }
    }

    public static void testViewShowTodoList(){
        addTodoList("satu");
        addTodoList("dua");
        addTodoList("tiga");
        addTodoList("emapat");
        addTodoList("lima");

        viewShowTodoList();
    }

    /**
     * Menampilkan view menambahkan Todo List
     */
    public static void viewAddTodoList(){
        System.out.println("MENAMBAH TODO LIST");
        var todo = input("todo(x jika batal)");

        if(todo.equals("x")){
            //batal
        } else {
            addTodoList(todo);
        }
    }

    public static void testViewAddTodoList(){
        addTodoList("satu");
        addTodoList("dua");
        addTodoList("tiga");

        viewAddTodoList();

        showTodoList();
    }

    /**
     * Menampilkan view menghapus Todo List
     */
    public static void viewRemoveTodoList(){
        System.out.println("MENGHAPUS TODO LIST");
        var number = input("Nomor yang dihapus(x jika batal)");

        if(number.equals("x")){
            //batal
        } else {
            boolean success = removeTodoList(Integer.valueOf(number));
            if(!success){
                System.out.println("Gagal Menghapus Todo List " + number);
            }
        }
    }

    public static void testViewRemoveTodoList(){
        addTodoList("Satu");
        addTodoList("Dua");
        addTodoList("Tiga");

        showTodoList();

        viewRemoveTodoList();

        showTodoList();
    }
}
