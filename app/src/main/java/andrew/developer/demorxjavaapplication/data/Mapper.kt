package andrew.developer.demorxjavaapplication.data

abstract class Mapper<From, To> {
    abstract fun mapToDB(from: From): To
    abstract fun mapToModel(to: To): From
}