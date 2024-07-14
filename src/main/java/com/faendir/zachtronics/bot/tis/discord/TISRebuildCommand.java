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

package com.faendir.zachtronics.bot.tis.discord;

import com.faendir.zachtronics.bot.discord.command.AbstractRebuildCommand;
import com.faendir.zachtronics.bot.discord.command.option.CommandOption;
import com.faendir.zachtronics.bot.discord.command.option.OptionHelpersKt;
import com.faendir.zachtronics.bot.discord.command.security.Secured;
import com.faendir.zachtronics.bot.tis.TISQualifier;
import com.faendir.zachtronics.bot.tis.model.TISPuzzle;
import com.faendir.zachtronics.bot.tis.repository.TISSolutionRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
@TISQualifier
public class TISRebuildCommand extends AbstractRebuildCommand<TISPuzzle> {
    @Getter
    private final CommandOption<String, TISPuzzle> puzzleOption = OptionHelpersKt.enumOptionBuilder("puzzle", TISPuzzle.class, TISPuzzle::getDisplayName)
            .description("Puzzle name. Can be shortened or abbreviated. E.g. `SIGN AMPL`, `ITP1`")
            .build();
    @Getter
    private final List<CommandOption<?, ?>> options = List.of(puzzleOption);
    @Getter
    private final Secured secured = TISSecured.WIKI_ADMINS_ONLY;
    @Getter
    private final TISSolutionRepository repository;
}
