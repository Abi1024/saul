package edu.illinois.cs.cogcomp.saulexamples.nlp.EmailSpam

import edu.illinois.cs.cogcomp.saulexamples.data.DocumentReader
import edu.illinois.cs.cogcomp.saulexamples.nlp.EmailSpam.spamClassifier2s.spamClassifier2

import scala.collection.JavaConversions._

object spamApp2 {

  def main(args: Array[String]): Unit = {
    /** Defining the data and specifying it's location  */
    val trainData = new DocumentReader("./data/EmailSpam/train").docs.toList
    val testData = new DocumentReader("./data/EmailSpam/test").docs.toList
    spamDataModel.docs populate trainData
    spamClassifier2.learn(30)
    spamClassifier2.learn(30)
    spamDataModel.testWith(testData)
    spamClassifier2.test(testData)
  }
}
