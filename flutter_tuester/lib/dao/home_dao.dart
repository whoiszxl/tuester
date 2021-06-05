
import 'package:flutter_tuester/http/core/zero_net.dart';
import 'package:flutter_tuester/http/request/home/blog_list_request.dart';
import 'package:flutter_tuester/model/micro_blog_list_model.dart';
import 'package:flutter_tuester/util/log_util.dart';

///主页dao数据访问层
class HomeDao {

  ///获取首页微博信息流(暂时实现为获取当前用户的)
  static Future getHomeMicroBlog() async {
    BlogListRequest bannerRequest = new BlogListRequest();

    var result = await ZeroNet.getInstance().request(bannerRequest);
    Log.debug("banner list" + result['data'].toString());
    return MicroBlogListModel.fromJson(result['data']);
  }
}