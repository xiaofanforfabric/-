package ai.good.village.aivillager;
/*
这个文件就是实体类了，创建一个类似村民的实体
比村民聪明多了（加强了AI—）
 */

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.world.World;

//创建实体类
public class IronVillager extends PathAwareEntity {
    private final MeleeAttackGoal meleeAttackGoal;

    public IronVillager(EntityType<? extends PathAwareEntity> entityType, World world) {
        super(entityType, world);
        this.meleeAttackGoal = new MeleeAttackGoal(this, 1.2D, false);
    }
//制定实体类
    public static DefaultAttributeContainer.Builder createIronVillagerAttributes() {
        return PathAwareEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 100.0D)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.25D)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 15.0D)
                .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 32.0D);
    }

    //实体AI类
    //寻找怪物目标
    @Override
    protected void initGoals() {
        this.goalSelector.add(4, this.meleeAttackGoal);
        // 添加其他目标...
    }

    @Override
    public void tick() {
        super.tick();

        // 检查是否有攻击目标
        LivingEntity target = this.getTarget();
        if (target != null) {
            // 计算攻击距离
            double distanceToTarget = this.squaredDistanceTo(target);
            if (distanceToTarget <= this.getWidth() * 2.0F && distanceToTarget > this.getWidth()) {
                // 如果在攻击范围内，则执行攻击
                this.meleeAttackGoal.start();
            } else {
                // 如果不在攻击范围内，则移动到目标附近
                this.getNavigation().startMovingTo(target, this.getAttributeValue(EntityAttributes.GENERIC_MOVEMENT_SPEED));
            }
        }
    }
}