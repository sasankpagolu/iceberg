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

import java.util.Collections;
import java.util.Optional;

public interface SupportsBulkOperations extends FileIO {

  /**
   * Delete the files at the given paths.
   *
   * @param pathsToDelete The paths to delete
   * @throws BulkDeletionFailureException in case of failure to delete at least 1 file
   */
  default void deleteFiles(Iterable<String> pathsToDelete) throws BulkDeletionFailureException {
    deleteFiles(pathsToDelete, Collections.emptyList());
  }

  /**
   * Deletes files and optionally tracks their sizes for reporting.
   *
   * @param pathsToDelete Paths of files to delete
   * @param sizes Optional sizes of files (in bytes), aligned with pathsToDelete
   * @throws BulkDeletionFailureException If deletion fails for any files
   */
  void deleteFiles(Iterable<String> pathsToDelete, Iterable<Optional<Long>> sizes)
      throws BulkDeletionFailureException;
}
