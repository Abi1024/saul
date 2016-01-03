package edu.illinois.cs.cogcomp.saulexamples.nlp.SemanticRoleLabeling

import edu.illinois.cs.cogcomp.core.datastructures.textannotation.{ Constituent, Relation }
import edu.illinois.cs.cogcomp.lbjava.learn.SparseAveragedPerceptron
import edu.illinois.cs.cogcomp.saul.classifier.Learnable
import edu.illinois.cs.cogcomp.saul.constraint.ConstraintTypeConversion._
import edu.illinois.cs.cogcomp.saul.datamodel.property.Property
import edu.illinois.cs.cogcomp.saulexamples.nlp.SemanticRoleLabeling.SRLDataModel._

object SRLClassifiers {
  //TODO This needs to be overriden by the user; change it to be dynamic
  val parameters = new SparseAveragedPerceptron.Parameters()
  //  parameters.modelDir = new ExamplesConfigurator().getDefaultConfig.getString(ExamplesConfigurator.MODELS_DIR.getFirst)
  object predicateClassifier extends Learnable[Constituent](SRLDataModel, parameters) {
    //TODO These are not used during Learner's initialization
    def label: Property[Constituent] = SRLDataModel.isPredicate
    import SRLDataModel._
    override def feature = using(posTag, subcategorization, phraseType, headword)
    override def algorithm = "SparseNetwork"
  }

  object argumentClassifier extends Learnable[Constituent](SRLDataModel, parameters) {
    def label = SRLDataModel.isArgument
  }

  object predicateSenseClassifier extends Learnable[Constituent](SRLDataModel, parameters) {
    def label = SRLDataModel.predicateSense
  }

  object argumentTypeLearner extends Learnable[Relation](SRLDataModel, parameters) {
    def label = SRLDataModel.argumentLabel
    import SRLDataModel._
    override def feature = using(headwordRelation, syntacticFrameRelation, pathRelation, subcategorizationRelation, phraseTypeRelation, predPosTag, predLemma, linearPosition)
  }

  object argumentXuIdentifierGivenApredicate extends Learnable[Relation](SRLDataModel, parameters) {
    def label = SRLDataModel.isArgumentXu
    override def feature = using(headwordRelation, syntacticFrameRelation, pathRelation, subcategorizationRelation, phraseTypeRelation, predPosTag, predLemma, linearPosition)
  }

}
