package interview

/*
 * problem links
 */
object Five {
    /*
     * http://stackoverflow.com/questions/12380478/bits-counting-algorithm-brian-kernighan-in-an-integer-time-complexity
     */
    //five
    def countBit(a:Int, c:Long=0): Long = a match {
        case 0 => c
        case _ => countBit(a & (a - 1), c + 1)
    }

    def five(a:Int, b:Int): Long = countBit(a ^ b)

    //eight
    def draw(from:Int, to:Int): Int = {
        0xFF & 0xFF>>from & 0xFF<<(7-to)
    }

    def printScreen(screen: Array[Int], width:Int) = {
        for( line <- screen.grouped(width/8)){
            println( line.map(BigInt(_)).map(_.toString(2)).mkString(",") )
        }
    }

    def drawHorizontalLine(screen: Array[Int], width:Int, x1:Int, x2:Int, y:Int): Unit = {
        val yy = y * width
        val xx1:Int = yy + x1
        val xx2:Int = yy + x2

        for( i <- (xx1/8 to xx2/8) ){
            screen(i) = draw(
                if(i*8 < xx1) xx1%8 else 0,
                if((i+1)*8 > xx2) xx2%8 else 7)
        }
    }
}
