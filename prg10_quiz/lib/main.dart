import 'package:flutter/material.dart';
import 'package:quiz/questions.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatefulWidget {
  @override
  _State createState() => _State();
}

class _State extends State<MyApp> {
  int questionNum = 0;
  int currentScore = 0;
  Questions questions = Questions();

  void updateQ(){
    setState(() {
      questionNum = questionNum + 1;
    });
  }

  bool checkQ(int questionNum){
    return questionNum < questions.questionBank.length ? true:false;
  }

  void updateScore(bool choice, int questionNum){
    if(questions.questionBank.length == questionNum) {
      print("End of the questions");
    }
    else {
      if(questions.questionBank[questionNum].answer == choice) {
        setState(() {
          currentScore++;
        });
      }
    }

  }
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: SafeArea(
        child: Scaffold(
          body: Container(
            margin: EdgeInsets.all(10.0),
            padding: EdgeInsets.all(10.0),
            child: Column(
              crossAxisAlignment: CrossAxisAlignment.stretch,
              children: [
                Center(
                  child: Text(
                    checkQ(questionNum)?questions.questionBank[questionNum].questionText.toString(): "End", 
                    style: TextStyle(fontSize: 40.0),
                  ),
                ),
                SizedBox(height: 10.0),
                if(checkQ(questionNum))
                RaisedButton(onPressed: (){
                  setState(() {
                    if(questions.questionBank.length == questionNum) {
                      print("End of the questions");
                    }
                    else {
                      updateScore(true, questionNum);
                      updateQ();
                    }
                  });
                },
                child: Text('TRUE', style: TextStyle(fontSize: 20.0),),),
                SizedBox(height: 10.0),
                if(checkQ(questionNum))
                RaisedButton(onPressed: (){
                  setState(() {
                    if(questions.questionBank.length == questionNum) {
                      print("End of the questions");
                    }
                    else {
                      updateScore(false, questionNum);
                      updateQ();
                    }
                  });
                },
                child: Text('FALSE', style: TextStyle(fontSize: 20.0),),),
                SizedBox(height: 40.0),
                Center(
                  child: Text(
                    'Current Score', style: TextStyle(fontSize: 30.0),
                  ),
                  ),
                  SizedBox(height: 40.0),
                  Center(
                    child: Text(
                      '${currentScore}',
                      style: TextStyle(fontSize: 30.0, fontWeight: FontWeight.bold),
                    ),
                  ),
              ],
            ),
          ),
        ),
        ),
    );
  }
}