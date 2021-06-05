import 'package:flutter/material.dart';
import 'package:flutter_tuester/dao/home_dao.dart';
import 'package:flutter_tuester/http/request/home/blog_list_request.dart';
import 'package:flutter_tuester/util/log_util.dart';

class HomePage extends StatefulWidget {
  @override
  _HomePageState createState() => _HomePageState();
}

class _HomePageState extends State<HomePage> {


  @override
  void initState() {
    var homeMicroBlog = HomeDao.getHomeMicroBlog();
    Log.info(homeMicroBlog);
    super.initState();
  }

  @override
  Widget build(BuildContext context) {



    return Scaffold(
      appBar: AppBar(),
      body: Container(
        child: Center(
          child: Text('首页'),
        ),
      ),
    );
  }
}