// Copyright 2019 Google LLC
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     https://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.google.sps.servlets;

import com.google.sps.data.ServerStats;
import java.io.IOException;
import java.util.Date;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/server-stats")
public final class ServerStatsServlet extends HttpServlet {

    /**
     *
     */
    private static final long serialVersionUID = -584335164289126456L;
    private final Date startTime = new Date();

  @Override
  public void doGet(final HttpServletRequest request, final HttpServletResponse response) throws IOException {
        // Calculate server stats
        final Date currentTime = new Date();
        final long maxMemory = Runtime.getRuntime().maxMemory();
        final long usedMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();

        // Convert the server stats to JSON
        final ServerStats serverStats = new ServerStats(startTime, currentTime, maxMemory, usedMemory);
        final String json = convertToJson(serverStats);

        // Send the JSON as the response
        response.setContentType("application/json;");
        response.getWriter().println(json);
    }

    /**
     * Converts a ServerStats instance into a JSON string using manual String
     * concatentation.
     */
    private String convertToJson(final ServerStats serverStats) {
    String json = "{";
    json += "\"startTime\": ";
    json += "\"" + serverStats.getStartTime() + "\"";
    json += ", ";
    json += "\"currentTime\": ";
    json += "\"" + serverStats.getCurrentTime() + "\"";
    json += ", ";
    json += "\"maxMemory\": ";
    json += serverStats.getMaxMemory();
    json += ", ";
    json += "\"usedMemory\": ";
    json += serverStats.getUsedMemory();
    json += "}";
    return json;
    }
}
