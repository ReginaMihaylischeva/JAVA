package net.thumbtack.school.introduction;

public class FirstSteps {
    public int sum (int x, int y){
       return x+=y;
    }
    public int mul (int x, int y){
        return x*=y;
    }
    public int div (int x, int y){
        return x/=y;
    }
    public int mod (int x, int y){
        return x%=y;
    }
    public boolean isEqual (int x, int y){
        return x==y?true:false;
    }
    public boolean isGreater (int x, int y){
        return x>y?true:false;
    }
    public boolean isInsideRect(int xLeft, int yTop, int xRight, int yBottom, int x, int y){
    return ((xLeft <= x)&&(x <= xRight)&& (yTop <= y )&&(y<= yBottom))?true:false;
    }
    public int sum(int[] array){
        int Sum=0;

        for(int elem : array){
           Sum +=elem;
        }
        return Sum;
    }
    public int mul(int[] array){
        int Mul=1;
        for(int elem : array){
            Mul *=elem;
        }
        return array.length==0?0:Mul;
    }
    public int min(int[] array){
        int min = Integer.MAX_VALUE;
        for(int elem : array){
            if(elem < min)
            {  min = elem;}
        }
        return min;
    }
    public int max(int[] array){
        int max = Integer.MIN_VALUE;
        for(int elem : array){
            if(elem > max)
            {  max = elem;}
        }
        return max;
    }
    public double average(int[] array){
        double average=0;
        for(int elem : array){
           average+=elem;
        }
        average/=array.length;
     return array.length==0?0:average;
    }
    public boolean isSortedDescendant(int[] array){
        int count = 0;
        boolean rezult=false;
        if (array.length!=0) {
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i + 1]) {
                    count++;
                }
            }
          if   (count == array.length - 1){ rezult=true;}
        }else rezult=true;

     return  rezult;
    }
    public void cube(int[] array){
        for (int i = 0; i < array.length ; i++){
            array[i]=(int) Math.pow(array[i],3);
       }
    }
    public boolean find(int[]array, int value){
        boolean rezult=false;
        for(int elem : array){
            if (elem ==value) {
                rezult=true;
                break;
            }
        }
        return rezult;
    }
    public void reverse(int[]array){
        int arr=0;
        for(int i=0; i< array.length/2; i++){
            arr= array[i];
            array[i]=array[array.length-i-1];
            array[array.length-i-1]=arr;

        }
    }
    public boolean isPalindrome (int[] array){
       int count=0;
        for(int i=0; i< array.length/2; i++){
           if ( array[i]==array[array.length-i-1]){
               count++;
           }
        }
        return count==array.length/2?true:false;
    }
    public int sum(int[][] matrix){
        int sum=0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {

                sum += matrix[i][j];

                }
            }
          return sum;
        }

    public int max(int[][] matrix) {
        int max=Integer.MIN_VALUE;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j]>max) {
                    max = matrix[i][j];

                }
            }

        }
        return max;
    }
    public int diagonalMax(int[][] matrix){
        int max=0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if((i==j)&&(matrix[i][j])>max){
                    max=matrix[i][j];
                }
              }
         }
         return max;
    }
    public boolean isSortedDescendant(int[][] matrix){
        int rezult=0;
        int i = 0;
        for ( i = 0; i < matrix.length; i++) {
           if( isSortedDescendant(matrix[i])){
               rezult++;
           }

        }
        return rezult==i?true:false;
    }
}
