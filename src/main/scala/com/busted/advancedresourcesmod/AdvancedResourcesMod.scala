package com.busted.advancedresourcesmod

import net.minecraftforge.fml.common.Mod.EventHandler
import net.minecraftforge.fml.common.event.{FMLInitializationEvent, FMLPostInitializationEvent, FMLPreInitializationEvent}
import net.minecraftforge.fml.common.{Mod, SidedProxy}

/**
	*
	* @author Adam Martini
	*/
object AdvancedResourcesMod {
	final val MODID = "advancedresourcesmod"
	final val VERSION = "1.11a"
	final val GUIFACTORY = "minecraftbyexample.mbe70_configuration.MBEGuiFactory"
}
@Mod(
	modid = AdvancedResourcesMod.MODID,
	version = AdvancedResourcesMod.VERSION,
	guiFactory = AdvancedResourcesMod.GUIFACTORY
)
class AdvancedResourcesMod {
	// The instance of your mod that Forge uses.  Optional.
	@Mod.Instance(AdvancedResourcesMod.MODID)
	var instance: AdvancedResourcesMod = _

	// Says where the client and server 'proxy' code is loaded.
	@SidedProxy(
		clientSide = "minecraftbyexample.ClientOnlyProxy",
		serverSide = "minecraftbyexample.DedicatedServerProxy"
	)
	var proxy: CommonProxy = _

	@EventHandler def preInit(event: FMLPreInitializationEvent) {
		proxy.preInit()
	}

	@EventHandler def init(event: FMLInitializationEvent) {
		proxy.init()
	}

	@EventHandler def postInit(event: FMLPostInitializationEvent) {
		proxy.postInit()
	}

	/**
		* Prepend the name with the mod ID, suitable for ResourceLocations such as textures.
		*/
	def prependModID(name: String): String = AdvancedResourcesMod.MODID + ":" + name

}
