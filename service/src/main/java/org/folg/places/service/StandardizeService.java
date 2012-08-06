/*
 * Copyright 2012 Foundation for On-Line Genealogy, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.folg.places.service;

import org.folg.places.standardize.Standardizer;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 *  Return standardized place
 */
@Path("/standardize")
@Produces(MediaType.APPLICATION_JSON)
public class StandardizeService {
   @GET
   @Path("{text}")
   public List<Standardizer.PlaceScore> get(
           @PathParam("text") String text,
           @QueryParam("defaultCountry") String defaultCountry, // TODO currently unavailable
           @QueryParam("mode") String modeString,
           @QueryParam("max") int max) {

      Standardizer.Mode mode = Standardizer.Mode.BEST;
      if ("required".equalsIgnoreCase(modeString)) {
         mode = Standardizer.Mode.REQUIRED;
      }
      else if ("new".equalsIgnoreCase(modeString)) {
         mode = Standardizer.Mode.NEW;
      }

      if (max <= 0) {
         max = 3;
      }
      else if (max > 100) {
         max = 100;
      }

      List<Standardizer.PlaceScore> results  = Standardizer.getInstance().standardize(text, defaultCountry, mode, max);
      return results;
   }
}
