public class Tree {

        private Citizen root;

        public void insert(Citizen citizen){
            if(root == null){
                root = citizen;
            }else{
                insert(citizen, root);
            }
        }
        private void insert(Citizen citizen, Citizen current){
            if (citizen.getId() < current.getId()) {
                //Izquierda
                if(current.getLeft() != null){
                    insert(citizen, current.getLeft());
                }else{
                    current.setLeft(citizen);
                }
            }
            else if(citizen.getId() > current.getId()){
                //Derecha
                if(current.getRight() != null){
                    insert(citizen, current.getRight());
                }else{
                    current.setRight(citizen);
                }
            }else{
                //Igualdad

            }
        }


        public void inorder(){
            inorder(root);
        }
        private void inorder(Citizen current){
            if(current == null){
                return;
            }
            inorder(current.getRight());
            System.out.println(current.getId());
            inorder(current.getLeft());
        }

        public Citizen search(int goal){
            return search(goal, root);
        }

        private Citizen search(int goal, Citizen current){
            int contador = 1 ;
            if(current == null){
                System.out.println("found in "+(contador-1)+" iterations");
                return null;
            }
            if(goal == current.getId()){
                contador++ ;
                System.out.println("found in "+(contador-1)+" iterations");
                return current;
            }
            else if(goal < current.getId()){
                contador++ ;

                System.out.println("found in "+(contador-1)+" iterations");
                return search(goal, current.getLeft());
            } else{
                contador++ ;
                System.out.println("found in "+(contador-1)+" iterations");
                return search(goal, current.getRight());
            }
        }

        public Citizen delete(int goal){
            return delete(goal, root);
        }

        private Citizen delete(int goal, Citizen current){
            if(current == null){
                System.out.println("The citizen does not exist");
                return null;
            }
            if(current.getId() == goal){
                //1. Nodo Hoja
                if(current.getLeft() == null && current.getRight() == null){
                    if(current == root){
                        root = null;
                    }else{

                    }
                    return null;
                }
                //2. Nodo solo hijo izquierdo
                else if (current.getRight() == null){
                    if(current == root){
                        root = current.getLeft();
                    }
                    return current.getLeft();
                }
                //3. Nodo solo hijo derecho
                else if(current.getLeft() == null){
                    if(current == root){
                        root = current.getRight();
                    }
                    return current.getRight();
                }
                //4. Nodo con dos hijos
                else{
                    Citizen min = getMin(current.getRight());
                    //Transferencia de valores, NUNCA de conexiones
                    current.setId(min.getId());
                    //Hacer eliminación a partir de la derecha
                    Citizen subarbolDER = delete(min.getId(), current.getRight());
                    current.setRight( subarbolDER );
                    return current;
                }


            }else if(goal < current.getId()){
                Citizen subArbolIzquierdo = delete(goal, current.getLeft());
                current.setLeft(subArbolIzquierdo);
                return current;
            }else{
                Citizen subArbolDerecho = delete(goal, current.getRight());
                current.setRight(subArbolDerecho);
                return current;
            }
        }

        public Citizen getMin(Citizen current){
            if(current.getLeft() == null){
                return current;
            }
            return getMin(current.getLeft());
        }




    }

