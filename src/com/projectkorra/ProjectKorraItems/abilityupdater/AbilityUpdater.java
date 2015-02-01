package com.projectkorra.ProjectKorraItems.abilityupdater;

import java.util.HashSet;
import java.util.concurrent.ConcurrentHashMap;

import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import com.projectkorra.ProjectKorra.airbending.AirBlast;
import com.projectkorra.ProjectKorra.airbending.AirBubble;
import com.projectkorra.ProjectKorra.airbending.AirScooter;
import com.projectkorra.ProjectKorra.airbending.AirShield;
import com.projectkorra.ProjectKorra.airbending.AirSpout;
import com.projectkorra.ProjectKorra.airbending.AirSuction;
import com.projectkorra.ProjectKorra.airbending.AirSwipe;
import com.projectkorra.ProjectKorra.airbending.Tornado;
import com.projectkorra.ProjectKorra.chiblocking.AcrobatStance;
import com.projectkorra.ProjectKorra.chiblocking.RapidPunch;
import com.projectkorra.ProjectKorra.chiblocking.WarriorStance;
import com.projectkorra.ProjectKorra.earthbending.Catapult;
import com.projectkorra.ProjectKorra.earthbending.EarthArmor;
import com.projectkorra.ProjectKorra.earthbending.EarthBlast;
import com.projectkorra.ProjectKorra.earthbending.EarthSmash;
import com.projectkorra.ProjectKorra.earthbending.EarthTunnel;
import com.projectkorra.ProjectKorra.earthbending.Ripple;
import com.projectkorra.ProjectKorra.earthbending.Shockwave;
import com.projectkorra.ProjectKorra.firebending.Cook;
import com.projectkorra.ProjectKorra.firebending.FireBlast;
import com.projectkorra.ProjectKorra.firebending.FireJet;
import com.projectkorra.ProjectKorra.firebending.FireShield;
import com.projectkorra.ProjectKorra.firebending.FireStream;
import com.projectkorra.ProjectKorra.firebending.Fireball;
import com.projectkorra.ProjectKorra.firebending.Lightning;
import com.projectkorra.ProjectKorra.firebending.WallOfFire;
import com.projectkorra.ProjectKorra.waterbending.Bloodbending;
import com.projectkorra.ProjectKorra.waterbending.IceBlast;
import com.projectkorra.ProjectKorra.waterbending.IceSpike;
import com.projectkorra.ProjectKorra.waterbending.IceSpike2;
import com.projectkorra.ProjectKorra.waterbending.OctopusForm;
import com.projectkorra.ProjectKorra.waterbending.Torrent;
import com.projectkorra.ProjectKorra.waterbending.TorrentBurst;
import com.projectkorra.ProjectKorra.waterbending.WaterManipulation;
import com.projectkorra.ProjectKorra.waterbending.WaterSpout;
import com.projectkorra.ProjectKorra.waterbending.WaterWall;
import com.projectkorra.ProjectKorra.waterbending.WaterWave;
import com.projectkorra.ProjectKorra.waterbending.Wave;
import com.projectkorra.ProjectKorraItems.ProjectKorraItems;
import com.projectkorra.ProjectKorraItems.attribute.AttributeListener;
import com.projectkorra.ProjectKorraItems.attribute.AttributeUtils;
import com.projectkorra.ProjectKorraItems.attribute.AttributeListener.Action;

public class AbilityUpdater {
	/** 
	 * Confirming an ability instance causes the charges on an item to decrease.
	 * To avoid causing unnecessary charge decreases we use a confirmation system
	 * to double check that the ability actually got executed once the player
	 * clicks or shifts.
	 */
	public static final ConcurrentHashMap<Player, BukkitRunnable> CONFIRM_CLICK = new ConcurrentHashMap<Player, BukkitRunnable>();
	public static final ConcurrentHashMap<Player, BukkitRunnable> CONFIRM_SHIFT = new ConcurrentHashMap<Player, BukkitRunnable>();

	
	public static final long CLEANUP_TIME = 300000;
	private static final ConcurrentHashMap<Object, Long> UPDATED_ABILITIES = new ConcurrentHashMap<Object, Long>();
	private static BukkitRunnable updater, cleaner;
	
	private AbilityUpdater(){}
	
	/**
	 * Hooks into the instance maps of all the ProjectKorra
	 * abilities, searching for any new instances of abilities.
	 * When a new ability is found it is put into UPDATED_ABILITIES.
	 */
	public static void startUpdater() {
		updater = new BukkitRunnable() {
			public void run() {
				for(Integer ID : AirBlast.instances.keySet()) {
					AirBlast abil = AirBlast.instances.get(ID);
					if(!UPDATED_ABILITIES.containsKey(abil)) {
						UPDATED_ABILITIES.put(abil, System.currentTimeMillis());
						updateAbility(abil.getPlayer(), abil);
					}
				}
				for(Integer ID : AirSwipe.instances.keySet()) {
					AirSwipe abil = AirSwipe.instances.get(ID);
					if(!UPDATED_ABILITIES.containsKey(abil)) {
						UPDATED_ABILITIES.put(abil, System.currentTimeMillis());
						updateAbility(abil.getPlayer(), abil);
					}
				}
				for(Integer ID : AirShield.instances.keySet()) {
					AirShield abil = AirShield.instances.get(ID);
					if(!UPDATED_ABILITIES.containsKey(abil)) {
						UPDATED_ABILITIES.put(abil, System.currentTimeMillis());
						updateAbility(abil.getPlayer(), abil);
					}
				}
				for(Integer ID : AirBubble.instances.keySet()) {
					AirBubble abil = AirBubble.instances.get(ID);
					if(!UPDATED_ABILITIES.containsKey(abil)) {
						UPDATED_ABILITIES.put(abil, System.currentTimeMillis());
						updateAbility(abil.getPlayer(), abil);
					}
				}
				for(Player ID : AirScooter.instances.keySet()) {
					AirScooter abil = AirScooter.instances.get(ID);
					if(!UPDATED_ABILITIES.containsKey(abil)) {
						UPDATED_ABILITIES.put(abil, System.currentTimeMillis());
						updateAbility(abil.getPlayer(), abil);
					}
				}
				for(Integer ID : Tornado.instances.keySet()) {
					Tornado abil = Tornado.instances.get(ID);
					if(!UPDATED_ABILITIES.containsKey(abil)) {
						UPDATED_ABILITIES.put(abil, System.currentTimeMillis());
						updateAbility(abil.getPlayer(), abil);
					}
				}
				for(Player ID : AirSpout.instances.keySet()) {
					AirSpout abil = AirSpout.instances.get(ID);
					if(!UPDATED_ABILITIES.containsKey(abil)) {
						UPDATED_ABILITIES.put(abil, System.currentTimeMillis());
						updateAbility(abil.getPlayer(), abil);
					}
				}
				for(Integer ID : AirSuction.instances.keySet()) {
					AirSuction abil = AirSuction.instances.get(ID);
					if(!UPDATED_ABILITIES.containsKey(abil)) {
						UPDATED_ABILITIES.put(abil, System.currentTimeMillis());
						updateAbility(abil.getPlayer(), abil);
					}
				}
				
				for(Player ID : AcrobatStance.instances.keySet()) {
					AcrobatStance abil = AcrobatStance.instances.get(ID);
					if(!UPDATED_ABILITIES.containsKey(abil)) {
						UPDATED_ABILITIES.put(abil, System.currentTimeMillis());
						updateAbility(abil.getPlayer(), abil);
					}
				}
				for(Player ID : RapidPunch.instances.keySet()) {
					RapidPunch abil = RapidPunch.instances.get(ID);
					if(!UPDATED_ABILITIES.containsKey(abil)) {
						UPDATED_ABILITIES.put(abil, System.currentTimeMillis());
						updateAbility(abil.getPlayer(), abil);
					}
				}
				for(Player ID : WarriorStance.instances.keySet()) {
					WarriorStance abil = WarriorStance.instances.get(ID);
					if(!UPDATED_ABILITIES.containsKey(abil)) {
						UPDATED_ABILITIES.put(abil, System.currentTimeMillis());
						updateAbility(abil.getPlayer(), abil);
					}
				}
				
				for(Integer ID : Catapult.instances.keySet()) {
					Catapult abil = Catapult.instances.get(ID);
					if(!UPDATED_ABILITIES.containsKey(abil)) {
						UPDATED_ABILITIES.put(abil, System.currentTimeMillis());
						updateAbility(abil.getPlayer(), abil);
					}
				}
				for(Player ID : EarthArmor.instances.keySet()) {
					EarthArmor abil = EarthArmor.instances.get(ID);
					if(!UPDATED_ABILITIES.containsKey(abil)) {
						UPDATED_ABILITIES.put(abil, System.currentTimeMillis());
						updateAbility(abil.getPlayer(), abil);
					}
				}
				for(Integer ID : EarthBlast.instances.keySet()) {
					EarthBlast abil = EarthBlast.instances.get(ID);
					if(!UPDATED_ABILITIES.containsKey(abil)) {
						UPDATED_ABILITIES.put(abil, System.currentTimeMillis());
						updateAbility(abil.getPlayer(), abil);
					}
				}
				for(Player ID : EarthTunnel.instances.keySet()) {
					EarthTunnel abil = EarthTunnel.instances.get(ID);
					if(!UPDATED_ABILITIES.containsKey(abil)) {
						UPDATED_ABILITIES.put(abil, System.currentTimeMillis());
						updateAbility(abil.getPlayer(), abil);
					}
				}
				for(Integer ID : Ripple.instances.keySet()) {
					Ripple abil = Ripple.instances.get(ID);
					if(!UPDATED_ABILITIES.containsKey(abil)) {
						UPDATED_ABILITIES.put(abil, System.currentTimeMillis());
						updateAbility(abil.getPlayer(), abil);
					}
				}
				for(Player ID : Shockwave.instances.keySet()) {
					Shockwave abil = Shockwave.instances.get(ID);
					if(!UPDATED_ABILITIES.containsKey(abil)) {
						UPDATED_ABILITIES.put(abil, System.currentTimeMillis());
						updateAbility(abil.getPlayer(), abil);
					}
				}
				for(EarthSmash abil : EarthSmash.instances)
					if(!UPDATED_ABILITIES.containsKey(abil)) {
						UPDATED_ABILITIES.put(abil, System.currentTimeMillis());
						updateAbility(abil.getPlayer(), abil);
					}
				/*for(Player ID : MetalClips.instances.keySet()) {
					MetalClips abil = MetalClips.instances.get(ID);
					if(!UPDATED_ABILITIES.containsKey(abil)) {
						UPDATED_ABILITIES.put(abil, System.currentTimeMillis());
						updateAbility(abil.getPlayer(), abil);
					}
				}*/
				
				
				for(Player ID : Cook.instances.keySet()) {
					Cook abil = Cook.instances.get(ID);
					if(!UPDATED_ABILITIES.containsKey(abil)) {
						UPDATED_ABILITIES.put(abil, System.currentTimeMillis());
						updateAbility(abil.getPlayer(), abil);
					}
				}
				for(Integer ID : Fireball.instances.keySet()) {
					Fireball abil = Fireball.instances.get(ID);
					if(!UPDATED_ABILITIES.containsKey(abil)) {
						UPDATED_ABILITIES.put(abil, System.currentTimeMillis());
						updateAbility(abil.getPlayer(), abil);
					}
				}
				for(Integer ID : FireBlast.instances.keySet()) {
					FireBlast abil = FireBlast.instances.get(ID);
					if(!UPDATED_ABILITIES.containsKey(abil)) {
						UPDATED_ABILITIES.put(abil, System.currentTimeMillis());
						updateAbility(abil.getPlayer(), abil);
					}
				}
				for(Player ID : FireJet.instances.keySet()) {
					FireJet abil = FireJet.instances.get(ID);
					if(!UPDATED_ABILITIES.containsKey(abil)) {
						UPDATED_ABILITIES.put(abil, System.currentTimeMillis());
						updateAbility(abil.getPlayer(), abil);
					}
				}
				for(Player ID : FireShield.instances.keySet()) {
					FireShield abil = FireShield.instances.get(ID);
					if(!UPDATED_ABILITIES.containsKey(abil)) {
						UPDATED_ABILITIES.put(abil, System.currentTimeMillis());
						updateAbility(abil.getPlayer(), abil);
					}
				}
				for(Integer ID : FireStream.instances.keySet()) {
					FireStream abil = FireStream.instances.get(ID);
					if(!UPDATED_ABILITIES.containsKey(abil)) {
						UPDATED_ABILITIES.put(abil, System.currentTimeMillis());
						updateAbility(abil.getPlayer(), abil);
					}
				}
				for(Player ID : WallOfFire.instances.keySet()) {
					WallOfFire abil = WallOfFire.instances.get(ID);
					if(!UPDATED_ABILITIES.containsKey(abil)) {
						UPDATED_ABILITIES.put(abil, System.currentTimeMillis());
						updateAbility(abil.getPlayer(), abil);
					}
				}
				for(Lightning abil : Lightning.instances)
					if(!UPDATED_ABILITIES.containsKey(abil)) {
						UPDATED_ABILITIES.put(abil, System.currentTimeMillis());
						updateAbility(abil.getPlayer(), abil);
					}
				
				for(Player ID : Bloodbending.instances.keySet()) {
					Bloodbending abil = Bloodbending.instances.get(ID);
					if(!UPDATED_ABILITIES.containsKey(abil)) {
						UPDATED_ABILITIES.put(abil, System.currentTimeMillis());
						updateAbility(abil.getPlayer(), abil);
					}
				}
				for(Integer ID : IceBlast.instances.keySet()) {
					IceBlast abil = IceBlast.instances.get(ID);
					if(!UPDATED_ABILITIES.containsKey(abil)) {
						UPDATED_ABILITIES.put(abil, System.currentTimeMillis());
						updateAbility(abil.getPlayer(), abil);
					}
				}
				for(Integer ID : IceSpike.instances.keySet()) {
					IceSpike abil = IceSpike.instances.get(ID);
					if(!UPDATED_ABILITIES.containsKey(abil)) {
						UPDATED_ABILITIES.put(abil, System.currentTimeMillis());
						updateAbility(abil.getPlayer(), abil);
					}
				}
				for(Integer ID : IceSpike2.instances.keySet()) {
					IceSpike2 abil = IceSpike2.instances.get(ID);
					if(!UPDATED_ABILITIES.containsKey(abil)) {
						UPDATED_ABILITIES.put(abil, System.currentTimeMillis());
						updateAbility(abil.getPlayer(), abil);
					}
				}
				for(Player ID : OctopusForm.instances.keySet()) {
					OctopusForm abil = OctopusForm.instances.get(ID);
					if(!UPDATED_ABILITIES.containsKey(abil)) {
						UPDATED_ABILITIES.put(abil, System.currentTimeMillis());
						updateAbility(abil.getPlayer(), abil);
					}
				}
				for(Player ID : Torrent.instances.keySet()) {
					Torrent abil = Torrent.instances.get(ID);
					if(!UPDATED_ABILITIES.containsKey(abil)) {
						UPDATED_ABILITIES.put(abil, System.currentTimeMillis());
						updateAbility(abil.getPlayer(), abil);
					}
				}
				for(Integer ID : TorrentBurst.instances.keySet()) {
					TorrentBurst abil = TorrentBurst.instances.get(ID);
					if(!UPDATED_ABILITIES.containsKey(abil)) {
						UPDATED_ABILITIES.put(abil, System.currentTimeMillis());
						updateAbility(abil.getPlayer(), abil);
					}
				}
				for(Integer ID : WaterManipulation.instances.keySet()) {
					WaterManipulation abil = WaterManipulation.instances.get(ID);
					if(!UPDATED_ABILITIES.containsKey(abil)) {
						UPDATED_ABILITIES.put(abil, System.currentTimeMillis());
						updateAbility(abil.getPlayer(), abil);
					}
				}
				for(Player ID : WaterSpout.instances.keySet()) {
					WaterSpout abil = WaterSpout.instances.get(ID);
					if(!UPDATED_ABILITIES.containsKey(abil)) {
						UPDATED_ABILITIES.put(abil, System.currentTimeMillis());
						updateAbility(abil.getPlayer(), abil);
					}
				}
				for(WaterWave abil : WaterWave.instances)
					if(!UPDATED_ABILITIES.containsKey(abil)) {
						UPDATED_ABILITIES.put(abil, System.currentTimeMillis());
						updateAbility(abil.getPlayer(), abil);
					}
				for(Integer ID : WaterWall.instances.keySet()) {
					WaterWall abil = WaterWall.instances.get(ID);
					if(!UPDATED_ABILITIES.containsKey(abil)) {
						UPDATED_ABILITIES.put(abil, System.currentTimeMillis());
						updateAbility(abil.getPlayer(), abil);
					}
				}
				for(Integer ID : Wave.instances.keySet()) {
					Wave abil = Wave.instances.get(ID);
					if(!UPDATED_ABILITIES.containsKey(abil)) {
						UPDATED_ABILITIES.put(abil, System.currentTimeMillis());
						updateAbility(abil.getPlayer(), abil);
					}
				}
			}
		};
		updater.runTaskTimer(ProjectKorraItems.plugin, 0, 1);
	}
	
	/**
	 * The cleaner scans through each ability instance
	 * inside of UPDATED_ABILITIES and removes the oldest ones.
	 */
	public static void startCleanup() {
		cleaner = new BukkitRunnable() {
			public void run() {
				for (Object key : new HashSet<Object>(UPDATED_ABILITIES.keySet())) {
				    long val = UPDATED_ABILITIES.get(key);
				    if(System.currentTimeMillis() - val >= CLEANUP_TIME)
				    	UPDATED_ABILITIES.remove(key);
				}
			}
		};
		cleaner.runTaskTimer(ProjectKorraItems.plugin, 0, 600);
	}
	
	/**
	 * Attempts to update an ability based on the attribute
	 * effects of a specific player.
	 * @param player the player that initialized the ability
	 * @param ability the instance of a ProjectKorra ability
	 */
	public static void updateAbility(Player player, Object ability) {
		if(player == null)
			return;
		
		ConcurrentHashMap<String, Double> attribs = AttributeUtils.getSimplePlayerAttributeMap(player);
		if(FireUpdater.updateAbility(player, ability, attribs)) {}
		else if(WaterUpdater.updateAbility(player, ability, attribs)){}
		else if(AirUpdater.updateAbility(player, ability, attribs)){}
		else if(EarthUpdater.updateAbility(player, ability, attribs)) {}
		else if(ChiUpdater.updateAbility(player, ability, attribs)){}
		
		confirmAbility(player, CONFIRM_CLICK, AttributeListener.Action.LEFTCLICK);
		confirmAbility(player, CONFIRM_SHIFT, AttributeListener.Action.SHIFT);
	}
	
	/**
	 * When a player left clicks we can't be completely sure that
	 * the ability actually executed. If it didn't execute we can't take away
	 * a charge or click charge.
	 * 
	 * To determine if the click executed we will store the players name temporarily
	 * and then wait for the AbilityUpdater to let us know if it went through.
	 */
	public static void tryToConfirmClick(Player player, ConcurrentHashMap<Player, BukkitRunnable> map) {
		if(map.containsKey(player)) {
			map.get(player).cancel();
			CONFIRM_CLICK.remove(player);
		}
		
		final Player fplayer = player;
		final ConcurrentHashMap<Player, BukkitRunnable> fmap = map;
		BukkitRunnable br = new BukkitRunnable() {
			public void run() {
				fmap.remove(fplayer);
			}
		};
		br.runTaskLater(ProjectKorraItems.plugin, 3);
		map.put(player, br);
	}
	
	public static void confirmAbility(Player player, ConcurrentHashMap<Player, BukkitRunnable> map, Action type) {
		if(map.containsKey(player)) {
			map.get(player).cancel();
			map.remove(player);
			AttributeUtils.decreaseCharges(player, type);
		}
	}	
}
