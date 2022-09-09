public class Citizen {

        private Citizen left;
        private Citizen right;
        private String name ;
        private String date ;
        private int id ;
        private  String city ;

    public Citizen(int id, String name, String date, String city) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.city = city;
    }



        public Citizen getLeft() {
            return left;
        }

        public void setLeft(Citizen left) {
            this.left = left;
        }

        public Citizen getRight() {
            return right;
        }

        public void setRight(Citizen right) {
            this.right = right;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }
}

