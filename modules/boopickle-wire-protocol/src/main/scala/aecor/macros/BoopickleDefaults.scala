package aecor.macros

import boopickle._
import boopickle.Default.Pickler

object BoopickleDefaults
    extends ProvidedPicklers
    with Base
    with BasicImplicitPicklers
    with TransformPicklers
    with TuplePicklers
    with MaterializePicklerFallback

trait ProvidedPicklers {
  implicit def toPickler[T](implicit provided: ProvidedPickler[T]): Pickler[T] = provided
}
