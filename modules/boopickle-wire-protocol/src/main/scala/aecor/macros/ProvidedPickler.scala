package aecor.macros

import boopickle.Default.{PickleState, Pickler, UnpickleState}

trait ProvidedPickler[T] extends Pickler[T]

object ProvidedPickler {
  def apply[T](pickler: Pickler[T]): ProvidedPickler[T] = new ProvidedPickler[T] {
    def pickle(obj: T)(implicit state: PickleState): Unit = pickler.pickle(obj)

    def unpickle(implicit state: UnpickleState): T = pickler.unpickle
  }
}
