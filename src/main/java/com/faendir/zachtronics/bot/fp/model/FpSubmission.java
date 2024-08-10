/*
 * Copyright (c) 2024
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.faendir.zachtronics.bot.fp.model;

import com.faendir.zachtronics.bot.fp.validation.XBPGHSim;
import com.faendir.zachtronics.bot.model.Submission;
import com.faendir.zachtronics.bot.utils.Utils;
import com.faendir.zachtronics.bot.validation.ValidationResult;
import lombok.Value;
import lombok.With;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;

@Value
public class FpSubmission implements Submission<FpCategory, FpPuzzle> {
    @NotNull FpPuzzle puzzle;
    @NotNull FpScore score;
    @NotNull String author;
    @With String displayLink;
    @NotNull String data;

    @NotNull
    public static Collection<ValidationResult<FpSubmission>> fromData(@NotNull String data, String author) {
        return XBPGHSim.validateMultiExport(data, author);
    }

    @NotNull
    public static Collection<ValidationResult<FpSubmission>> fromLink(@NotNull String link, String author) {
        String data = Utils.downloadFile(link).dataAsString();
        return fromData(data, author);
    }
}
