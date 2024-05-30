package ai.good.village;
/*
他妈的，明明IDEA都没有报错，构建也成功了，但是客户端无法启动，报错这个模组出现问题
Java新手，写的fabric1.18.2模组
创建一个村民模型的实体
渲染器，注册都写了，就是启动不了
还请大佬帮帮忙，谢谢
客户端启动日志请看errorlog.txt
 */

import ai.good.village.aivillager.AivillageModEntities;
import ai.good.village.aivillager.IronVillager;
import ai.good.village.client.renderer.IronVillagerRenderer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import ai.good.village.aivillager.IronVillager;

//这里是主类注册文件
public class GoodAIvillage implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		EntityRendererRegistry.register(AivillageModEntities.IronVillager, IronVillagerRenderer::new);
	}
	//EntityRendererRegistry.register(AivillageModEntities.IronVillager, IronVillagerRenderer::new);
	//	}
	//注册实体渲染器，继承AivillageModEntities类
	public static final EntityType<IronVillager> IRON_VILLAGER = Registry.register(
			Registry.ENTITY_TYPE,
			new Identifier("aivillage", "iron_villager"),
			FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, IronVillager::new)
					.dimensions(EntityDimensions.fixed(0.6F, 1.95F))
					.build()
	);
//注册实体，继承ironvillager类
}
