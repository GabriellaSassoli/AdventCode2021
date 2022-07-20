package ovoInterview

object ovoExercise extends App {

  val input =  "lorem ipsum dolor sit amet consectetur lorem ipsum et mihi quoniam et adipiscing elit.sed quoniam et advesperascit et mihi ad villam revertendum est nunc quidem hactenus ex rebus enim timiditas non ex vocabulis nascitur.nummus in croesi divitiis obscuratur pars est tamen divitiarum.nam quibus rebus efficiuntur voluptates eae non sunt in potestate sapientis.hoc mihi cum tuo fratre convenit.qui ita affectus beatum esse numquam probabis duo reges constructio interrete.de hominibus dici non necesse est.eam si varietatem diceres intellegerem ut etiam non dicente te intellego parvi enim primo ortu sic iacent tamquam omnino sine animo sint.ea possunt paria non esse.quamquam tu hanc copiosiorem etiam soles dicere.de quibus cupio scire quid sentias.universa enim illorum ratione cum tota vestra confligendum puto.ut nemo dubitet eorum omnia officia quo spectare quid sequi quid fugere debeant nunc vero a primo quidem mirabiliter occulta natura est nec perspici nec cognosci potest.videmusne ut pueri ne verberibus quidem a contemplandis rebus perquirendisque deterreantur sunt enim prima elementa naturae quibus auctis virtutis quasi germen efficitur.nam ut sint illa vendibiliora haec uberiora certe sunt.cur deinde metrodori liberos commendas.mihi inquam qui te id ipsum rogavi nam adhuc meo fortasse vitio quid ego quaeram non perspicis.quibus ego vehementer assentior.cur iustitia laudatur mihi enim satis est ipsis non satis.quid est enim aliud esse versutum nobis heracleotes ille dionysius flagitiose descivisse videtur a stoicis propter oculorum dolorem.diodorus eius auditor adiungit ad honestatem vacuitatem doloris.nos quidem virtutes sic natae sumus ut tibi serviremus aliud negotii nihil habemus."
  val words = input.split("[. ]")
  val nOfWords: Int = words.length
  println("n of Words " + nOfWords)

  val sentences: List[String] = input.split("[.]").toList

  val nOfSentences = sentences.length
  println("n Of Sentences " + nOfSentences)

  val lengthOfLongestWord = words.map{
    word => word.length
  }.max

  println("length Of Longest Word " + lengthOfLongestWord)

  val top6Words = words.groupBy(identity).map{
    case (key, value) => (key,value.length)
  }.toList.sortBy(_._2).reverse.take(6)

  println("Top 6 words" + top6Words)

  val distinctWords = words.groupBy(identity).map{
    case (key, value) => (key,value.length)
  }.toList

  val totalNumberOfDistinctWords = distinctWords.length
  val nOfWordsThatOccurOnce = distinctWords.collect{
    case (word, nOfTimesUsed) if nOfTimesUsed == 1 => word
  }.length

  val percentageOfWordsOccuredOnce = (nOfWordsThatOccurOnce *100) / totalNumberOfDistinctWords
  println("Percentage of words occured only once " + percentageOfWordsOccuredOnce)


  val nOfWordsPerSentence: List[Int] = sentences.map{
    sentence => sentence.split(" ").length
  }

  val averageNOfWordsPerSentence = nOfWordsPerSentence.sum / nOfWordsPerSentence.length

  println("N of words per sentence " + averageNOfWordsPerSentence)

  val twoWordsFrases = (0 to words.length).map{
    i => words.slice(i, i + 2).toList
  }.groupBy(identity).map{
      case (key, value) => (key,value.length)
    }.toList.sortBy(_._2).reverse.take(3)

 twoWordsFrases.foreach(println(_))

}
