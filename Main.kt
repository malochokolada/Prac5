import kotlin.math.pow

open class Point(var _cordinataX : Double, var _cordinataY : Double) {
var cordinataX : Double
    var cordinataY : Double
    init { cordinataX = _cordinataX
        cordinataY = _cordinataY }

    open fun printInformation () {
        println("координаты точки: \n" +
                "X=$cordinataX \n" +
                "Y=$cordinataY")
    }
}

class ColoredPoint (_cordinataX: Double, _cordinataY: Double, _color: String): Point(_cordinataX,_cordinataY) {
     var color:String
     init {
         color = _color
     }

    override fun printInformation() {
        super.printInformation()
        println("Цвет= $color")
    }
}

open class Line(_pointOne:Point, _pointTwo: Point) {
    var pointOne: Point
    var pointTwo: Point
    var length: Double

    init {
        pointOne = _pointOne
        pointTwo = _pointTwo
        length = MathLength()

    }

 private fun MathLength(): Double {
        return Math.sqrt((pointTwo.cordinataX - pointOne.cordinataX).pow(2) + (pointTwo.cordinataY - pointOne.cordinataY).pow(2))
    }
    open fun printInformation () {
        println("Информация щб отрезке\n" +
                "Информация о первой точке")
        pointOne.printInformation()
        println("Информация о второй точке")
        pointTwo.printInformation()


}
}

class ColoredLine(_pointOne:Point, _pointTwo: Point, _color: String) : Line(_pointOne, _pointTwo) {
var color: String
      init {
          color = _color
      }
    override fun printInformation() {
        super.printInformation()
        println("Цвет линии= $color")
    }
}

class Polygone (_point1: Point, _point2: Point, _point3: Point, _point4: Point) {
    var point1: Point
    var point2: Point
    var point3: Point
    var point4: Point
    var length1: Line
    var length2: Line
    var length3: Line
    var length4: Line
    var AreaPol : Double
    init {
        point1 = _point1
        point2 = _point2
        point3 = _point3
        point4 = _point4
        length1 = Line(point1,point2)
        length2 =Line(point2,point3)
        length3 =Line(point3, point4)
        length4 = Line(point4, point1)
        AreaPol = Area()
    }

    fun Area() : Double {
        var areaPol: Double = ((point1.cordinataX * point2.cordinataY - point1.cordinataY * point2.cordinataX) +
               (point2.cordinataX * point3.cordinataY - point2.cordinataY * point3.cordinataX)+
                (point3.cordinataX * point4.cordinataY - point3.cordinataY * point4.cordinataX)+
                (point4.cordinataX * point1.cordinataY - point4.cordinataY * point1.cordinataX))/2

        if (areaPol < 0) areaPol*=-1
        return areaPol
    }
    fun printInformation (){
        println("Информация о Polygone\n" +
                "Информация о точках:\n" +
                "Точка 1: ")
        point1.printInformation()
        println( "Точка 2: ")
        point2.printInformation()
        println( "Точка 3: ")
        point3.printInformation()
        println( "Точка 4: ")
        point4.printInformation()

        println("Информация о гранях: \n" +
                "Грань 1: ")
        length1.printInformation()
        println("Грань 2: ")
        length2.printInformation()
        println("Грань 3: ")
        length3.printInformation()
        println("Грань 4: ")
        length4.printInformation()
        println("Плолщадь Polygone:$AreaPol")
    }
}

fun main(args: Array<String>) {
val pointText:Point= Point (1.0,1.0)
    pointText.printInformation()


    val coloredPointText:ColoredPoint = ColoredPoint(0.0, 5.0, "Красный")
    coloredPointText.printInformation()


    val lineText: Line=Line(Point(3.0,3.0), Point(10.0,10.0))
    lineText.printInformation()


    var polygoneText: Polygone = Polygone ( Point (1.0, 1.0),
                                            Point (5.0, 1.0),
                                            Point (5.0, 3.0),
                                            Point (1.0, 3.0))
    polygoneText.printInformation()
}