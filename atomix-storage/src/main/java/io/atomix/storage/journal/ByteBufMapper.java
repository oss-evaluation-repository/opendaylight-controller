/*
 * Copyright (c) 2024 PANTHEON.tech, s.r.o. and others.  All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.atomix.storage.journal;

import io.netty.buffer.ByteBuf;
import java.io.EOFException;
import java.io.IOException;
import org.eclipse.jdt.annotation.NonNullByDefault;

/**
 * Support for mapping of {@link ByteBufJournal} entries to and from {@link ByteBuf}s.
 */
@NonNullByDefault
public interface ByteBufMapper<T> {
    /**
     * Converts the contents of a {@link ByteBuf} to an object.
     *
     * @param index entry index
     * @param bytes entry bytes
     * @return resulting object
     */
    T bytesToObject(long index, ByteBuf bytes);

    /**
     * Converts an object into a series of bytes in the specified {@link ByteBuf}.
     *
     * @param obj the object
     * @param buf target buffer
     * @throws EOFException if the buffer does not have sufficient capacity
     * @throws IOException if some other I/O error occurs
     */
    void objectToBytes(T obj, ByteBuf buf) throws IOException;
}
