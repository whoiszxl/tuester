import 'package:flutter_tuester/http/request/base_request.dart';

class MemberInfoRequest extends BaseRequest {

  @override
  bool needLogin() {
    return true;
  }

  @override
  RequestMethod requestMethod() {
    return RequestMethod.POST;
  }

  @override
  String path() {
    return "/member/member/detail";
  }


}