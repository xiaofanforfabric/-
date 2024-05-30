
/*
 *也是渲染器注册，主类文件是继承这个文件进行注册
 */
package ai.good.village.aivillager;

import ai.good.village.client.renderer.IronVillagerRenderer;

import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.api.Environment;
import net.fabricmc.api.EnvType;
import ai.good.village.aivillager.IronVillager;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.VillagerEntity;
//    public static EntityType<? extends VillagerEntity> IronVillager;
//是定义这是ironvillager实体类的渲染器类

@Environment(EnvType.CLIENT)
public class AivillageModEntities {
    public static EntityType<? extends VillagerEntity> IronVillager;

//注册代码
    public static void load() {
        EntityRendererRegistry.register(AivillageModEntities.IronVillager, IronVillagerRenderer::new);
    }
}
