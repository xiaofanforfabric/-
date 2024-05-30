package ai.good.village.client.renderer;
/*
这个就是实体的渲染器
 */

import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.model.EntityModelLayers;
import net.minecraft.client.render.entity.model.VillagerResemblingModel;
import net.minecraft.entity.passive.VillagerEntity;
import net.minecraft.util.Identifier;

//实体类渲染器代码
public class IronVillagerRenderer extends MobEntityRenderer<VillagerEntity, VillagerResemblingModel<VillagerEntity>> {
    public IronVillagerRenderer(EntityRendererFactory.Context context) {
        super(context, new VillagerResemblingModel<>(context.getPart(EntityModelLayers.VILLAGER)), 0.5f);
    }
//定义实体模型纹理
    @Override
    public Identifier getTexture(VillagerEntity entity) {
        return new Identifier("aivillage:textures/entities/butcher.png");
    }
}