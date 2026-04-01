public class Map {
   private Room[][] roomGrid;
   

   public Map(int rows, int columns) {
      // TODO: initalize the Map by creating the 2D array
      roomGrid = new Room[rows][columns];
      populateMap();
      }
   public int getNumRows() {
         return roomGrid.length;
   }
   public int getNumCols() {
         return roomGrid[0].length;
   }
   public void populateMap() {
      for(int row=0;row<roomGrid.length;row++){
         for(int column = 0; column <roomGrid[0].length; column++){
            roomGrid[row][column]=new Room();
         }
      }
   }
   public Room getRoom(int row, int column) {
      return roomGrid[row][column];
   }
   
   public Room getRandomRoom() {
      return roomGrid[(int)(Math.random()*roomGrid.length)][(int)(Math.random()*roomGrid[1].length)];
   }
}
  