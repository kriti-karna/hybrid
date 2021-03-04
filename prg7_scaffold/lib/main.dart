import 'package:flutter/material.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
        home: SafeArea(
      child: Scaffold(
        appBar: AppBar(
          title: Text("First Lab"),
        ),
        body: Column(mainAxisAlignment: MainAxisAlignment.end, children: [
          Row(mainAxisAlignment: MainAxisAlignment.center, children: [
            Text(
              "More text",
              style: TextStyle(fontSize: 15, color: Colors.red),
            ),
            Text(
              "More text",
              style: TextStyle(fontSize: 15, color: Colors.green),
            ),
          ]),
          Row(mainAxisAlignment: MainAxisAlignment.end, children: [
            Text(
              "More text",
              style: TextStyle(fontSize: 15, color: Colors.red),
            ),
            Text(
              "More text",
              style: TextStyle(fontSize: 15, color: Colors.green),
            ),
          ])
        ]),
      ),
    ));
  }
}
