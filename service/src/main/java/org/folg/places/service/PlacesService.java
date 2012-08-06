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

import org.folg.places.standardize.Place;
import org.folg.places.standardize.Standardizer;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 *  Look up place
 */
@Path("/places")
@Produces(MediaType.APPLICATION_JSON)
public class PlacesService {
   @GET
   @Path("{id}")
   public Place get(@PathParam("id") int id) {
      return Standardizer.getInstance().getPlace(id);
   }
}
