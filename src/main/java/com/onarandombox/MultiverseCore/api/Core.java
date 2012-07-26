/******************************************************************************
 * Multiverse 2 Copyright (c) the Multiverse Team 2011.                       *
 * Multiverse 2 is licensed under the BSD License.                            *
 * For more information please check the README.md file included              *
 * with this project.                                                         *
 ******************************************************************************/

package com.onarandombox.MultiverseCore.api;

import buscript.Buscript;
import com.fernferret.allpay.AllPay;
import com.fernferret.allpay.GenericBank;
import com.onarandombox.MultiverseCore.destination.DestinationFactory;
import com.onarandombox.MultiverseCore.utils.*;
import com.pneumaticraft.commandhandler.CommandHandler;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

/**
 * Multiverse 2 Core API
 * <p>
 * This API contains a bunch of useful things you can get out of Multiverse in general!
 */
public interface Core {

    /**
     * Gets the Multiverse config file.
     *
     * @return The Multiverse config file.
     * @deprecated Don't modify the config-file manually!
     */
    @Deprecated
    FileConfiguration getMVConfiguration();

    /**
     * Gets the Banking system that Multiverse-Core has hooked into.
     *
     * @return A {@link GenericBank} that can be used for payments.
     */
    GenericBank getBank();

    /**
     * Reloads the Multiverse Configuration files:
     * worlds.yml and config.yml.
     */
    void loadConfigs();

    /**
     * Gets the Multiverse message system. This allows you to send messages
     * to users at specified intervals.
     *
     * @return The loaded {@link MultiverseMessaging}.
     */
    MultiverseMessaging getMessaging();

    /**
     * Gets the {@link MVPlayerSession} for the given player.
     * This will also create a player session if one does not exist
     * for a player.
     *
     * @param player The player's session to grab.
     *
     * @return The corresponding {@link MVPlayerSession}.
     */
    MVPlayerSession getPlayerSession(Player player);

    /**
     * Gets the instantiated Safe-T-Teleporter for performing
     * safe teleports.
     *
     * @return A non-null {@link SafeTTeleporter}.
     *
     * @deprecated Use {@link #getSafeTTeleporter()} instead.
     */
    @Deprecated
    com.onarandombox.MultiverseCore.utils.SafeTTeleporter getTeleporter();

    /**
     * Multiverse uses an advanced permissions setup, this object
     * simplifies getting/setting permissions.
     *
     * @return A non-null {@link MVPermissions}.
     */
    MVPermissions getMVPerms();

    /**
     * Multiverse uses {@link CommandHandler} to make adding and using commands
     * a piece of cake.
     *
     * @return A non-null {@link CommandHandler}.
     */
    CommandHandler getCommandHandler();

    /**
     * Gets the factory class responsible for loading many different destinations
     * on demand.
     *
     * @return A valid {@link DestinationFactory}.
     */
    DestinationFactory getDestFactory();

    /**
     * Gets the primary class responsible for managing Multiverse Worlds.
     *
     * @return {@link WorldManager}.
     */
    MVWorldManager getMVWorldManager();

    /**
     * Saves all configs.
     *
     * @return Whether the config was successfully saved
     */
    boolean saveMVConfigs();

    /**
     * Gets the {@link AnchorManager}.
     *
     * @return The {@link AnchorManager}
     */
    AnchorManager getAnchorManager();

    /**
     * Used by queued commands to regenerate a world on a delay.
     *
     * @param name Name of the world to regenerate
     * @param useNewSeed If a new seed should be used
     * @param randomSeed IF the new seed should be random
     * @param seed The seed of the world.
     *
     * @return True if success, false if fail.
     */
    Boolean regenWorld(String name, Boolean useNewSeed, Boolean randomSeed, String seed);

    /**
     * Sets the {@link GenericBank}-Bank AllPay is using.
     *
     * @param bank The new {@link GenericBank}
     */
    void setBank(GenericBank bank);

    /**
     * Gets this plugin's {@link AllPay}-Banker.
     *
     * @return An {@link AllPay}-Banker
     */
    AllPay getBanker();

    /**
     * Decrements the number of plugins that have specifically hooked into core.
     */
    void decrementPluginCount();

    /**
     * Increments the number of plugins that have specifically hooked into core.
     */
    void incrementPluginCount();

    /**
     * Returns the number of plugins that have specifically hooked into core.
     *
     * @return The number if plugins that have hooked into core.
     */
    int getPluginCount();

    /**
     * Parse the Authors Array into a readable String with ',' and 'and'.
     *
     * @return The readable authors-{@link String}
     */
    String getAuthors();

    /**
     * Gets the {@link BlockSafety} this {@link Core} is using.
     * @return The {@link BlockSafety} this {@link Core} is using.
     * @see BlockSafety
     * @see SimpleBlockSafety
     */
    BlockSafety getBlockSafety();

    /**
     * Sets the {@link BlockSafety} this {@link Core} is using.
     * @param blockSafety The new {@link BlockSafety}.
     * @see BlockSafety
     * @see SimpleBlockSafety
     */
    void setBlockSafety(BlockSafety blockSafety);

    /**
     * Gets the {@link LocationManipulation} this {@link Core} is using.
     * @return The {@link LocationManipulation} this {@link Core} is using.
     * @see LocationManipulation
     * @see SimpleLocationManipulation
     */
    LocationManipulation getLocationManipulation();

    /**
     * Sets the {@link LocationManipulation} this {@link Core} is using.
     * @param locationManipulation The new {@link LocationManipulation}.
     * @see LocationManipulation
     * @see SimpleLocationManipulation
     */
    void setLocationManipulation(LocationManipulation locationManipulation);

    /**
     * Gets the {@link SafeTTeleporter} this {@link Core} is using.
     * @return The {@link SafeTTeleporter} this {@link Core} is using.
     * @see SafeTTeleporter
     * @see SimpleSafeTTeleporter
     */
    SafeTTeleporter getSafeTTeleporter();

    /**
     * Sets the {@link SafeTTeleporter} this {@link Core} is using.
     * @param safeTTeleporter The new {@link SafeTTeleporter}.
     * @see SafeTTeleporter
     * @see SimpleSafeTTeleporter
     */
    void setSafeTTeleporter(SafeTTeleporter safeTTeleporter);

    /**
     * Gets the {@link MultiverseCoreConfig}.
     * @return The configuration.
     */
    MultiverseCoreConfig getMVConfig();

    /**
     * Gets the buscript object for Multiverse.  This is what handles Javascript processing.
     *
     * @return The Multiverse buscript object.
     */
    Buscript getScriptAPI();
}
