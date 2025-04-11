/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.iceberg.io;

import java.util.Locale;

public class BulkDeletionFailureException extends RuntimeException {
  private final int numberFailedObjects;
  private final long sizeofFailedObjects;

  public BulkDeletionFailureException(int numberFailedObjects) {
    super(String.format(Locale.ROOT, "Failed to delete %d files", numberFailedObjects));
    this.numberFailedObjects = numberFailedObjects;
    this.sizeofFailedObjects = 0;
  }

  public BulkDeletionFailureException(int numberFailedObjects, long sizeofFailedObjects) {
    super(String.format(Locale.ROOT, "Failed to delete %d files", numberFailedObjects));
    this.numberFailedObjects = numberFailedObjects;
    this.sizeofFailedObjects = sizeofFailedObjects;
  }

  public int numberFailedObjects() {
    return numberFailedObjects;
  }

  public long sizeofFailedObjects() {
    return sizeofFailedObjects;
  }
}
