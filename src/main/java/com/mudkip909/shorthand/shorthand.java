package com.mudkip909.shorthand;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.logging.LogUtils;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.world.level.GameType;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.event.RegisterCommandsEvent;

import java.util.function.Predicate;

@Mod(shorthand.MOD_ID)
@Mod.EventBusSubscriber(modid = shorthand.MOD_ID)
public class shorthand
{
    public static final String MOD_ID = "shorthand";

    public shorthand()
    {
        MinecraftForge.EVENT_BUS.register(this);
    }



    @SubscribeEvent
    public static void registerCommands(RegisterCommandsEvent event)
    {
        CommandDispatcher commandDispatcher = event.getDispatcher();
        Predicate<CommandSourceStack> isPlayer = source -> {
            try {
                return source.getPlayerOrException() != null;
            } catch(CommandSyntaxException e) {
                return false;
            }
        };

        commandDispatcher.register(Commands.literal("gamemode").then(Commands.literal("c").executes((command) -> {
            ServerPlayer player = command.getSource().getPlayerOrException();

                player.setGameMode(GameType.CREATIVE);

            return 1;
        })));
        commandDispatcher.register(Commands.literal("gamemode").then(Commands.literal("s").executes((command) -> {
            ServerPlayer player = command.getSource().getPlayerOrException();

                player.setGameMode(GameType.SURVIVAL);

            return 1;
        })));
        commandDispatcher.register(Commands.literal("gamemode").then(Commands.literal("a").executes((command) -> {
            ServerPlayer player = command.getSource().getPlayerOrException();

                player.setGameMode(GameType.ADVENTURE);

            return 1;
        })));
        commandDispatcher.register(Commands.literal("gamemode").then(Commands.literal("sp").executes((command) -> {
            ServerPlayer player = command.getSource().getPlayerOrException();

                player.setGameMode(GameType.SPECTATOR);

            return 1;
        })));
        commandDispatcher.register(Commands.literal("gamemode").then(Commands.literal("1").executes((command) -> {
            ServerPlayer player = command.getSource().getPlayerOrException();

                player.setGameMode(GameType.CREATIVE);

            return 1;
        })));
        commandDispatcher.register(Commands.literal("gamemode").then(Commands.literal("0").executes((command) -> {
            ServerPlayer player = command.getSource().getPlayerOrException();

                player.setGameMode(GameType.SURVIVAL);

            return 1;
        })));
        commandDispatcher.register(Commands.literal("gamemode").then(Commands.literal("2").executes((command) -> {
            ServerPlayer player = command.getSource().getPlayerOrException();

                player.setGameMode(GameType.ADVENTURE);

            return 1;
        })));
        commandDispatcher.register(Commands.literal("gamemode").then(Commands.literal("3").executes((command) -> {
            ServerPlayer player = command.getSource().getPlayerOrException();

                player.setGameMode(GameType.SPECTATOR);

            return 1;
        })));
    }
}
