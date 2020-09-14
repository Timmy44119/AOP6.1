package com.axelor.apps.base.tracking;

import com.axelor.exception.service.TraceBackService;
import com.axelor.rpc.ActionRequest;
import com.axelor.rpc.ActionResponse;
import com.axelor.rpc.Context;

public class GlobalTrackingLogController {

  public void showGlobalTrackingLogsInWizard(ActionRequest request, ActionResponse response) {
    try {

      Context context = request.getContext();
      boolean showLines = context.get("metaModel") != null && context.get("metaField") != null;

      response.setAttr("globalTrackingLogDashlet", "hidden", showLines);
      response.setAttr("globalTrackingLogLineDashlet", "hidden", !showLines);

      response.setAttr(
          showLines ? "globalTrackingLogLineDashlet" : "globalTrackingLogDashlet", "refresh", true);
    } catch (Exception e) {
      TraceBackService.trace(response, e);
    }
  }
}