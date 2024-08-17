package top.block_sdu.mixin;


import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Fallable;
import net.minecraft.world.level.block.FallingBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(FallingBlock.class)
public abstract class FallingBlockMixin extends Block implements Fallable {
    public FallingBlockMixin(Properties properties) {
        super(properties);
    }

    @Inject(method = "isFree",at=@At("HEAD"), cancellable = true)
    private static void isFree(BlockState blockState, CallbackInfoReturnable<Boolean> cir) {
        cir.setReturnValue(false);
    }
    }

