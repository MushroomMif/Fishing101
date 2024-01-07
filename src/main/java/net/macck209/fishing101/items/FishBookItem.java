package net.macck209.fishing101.items;

import eu.pb4.polymer.core.api.item.PolymerItem;
import eu.pb4.sgui.api.elements.BookElementBuilder;
import eu.pb4.sgui.api.gui.BookGui;
import net.macck209.fishing101.polymer.PolymerTextures;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtElement;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.text.Text;
import net.minecraft.util.*;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FishBookItem extends Item implements PolymerItem {

    public FishBookItem(Item.Settings settings) {
        super(settings);
    }

    @Override
    public int getPolymerCustomModelData(ItemStack itemStack, @Nullable ServerPlayerEntity player) {return PolymerTextures.MODELS.get(this).value();}

    @Override
    public Item getPolymerItem(ItemStack itemStack, @Nullable ServerPlayerEntity player) {
        return Items.WRITTEN_BOOK;
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if (user instanceof ServerPlayerEntity player) {
            new IndexGui(player, hand).open();
            user.useBook(user.getStackInHand(hand), hand);
            user.incrementStat(Stats.USED.getOrCreateStat(this));
            return TypedActionResult.success(user.getStackInHand(hand), true);
        }

        return super.use(world, user, hand);
    }

    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        if (stack.hasNbt()) {
            NbtCompound nbtCompound = stack.getNbt();
            String string = "Dr. Finn Benthos";
            if (!StringHelper.isEmpty(string)) {
                tooltip.add(Text.translatable("book.byAuthor", string).formatted(Formatting.GRAY));
            }

            assert nbtCompound != null;
            tooltip.add(Text.translatable("book.generation." + nbtCompound.getInt("generation")).formatted(Formatting.GRAY));
        }

    }


    public static void build(){
        var builder = new BookElementBuilder();
        FishGui.BOOKS.clear();

        builder.addPage(
                //Text.translatable("books.fishing101.fish_book.intro")
                Text.literal("   Октябрь 12, 1878\n"),
                Text.literal("Меня зовут Финн Бентос. " +
                        "На страницах этого дневника будут запечатлены интригующие морские существа, с которыми я сталкиваюсь во время своего путешествия в неизвестность. " +
                        "Моя цель - разгадать тайны, скрытые в водном царстве.")
        );
        builder.addPage(
                Text.literal("   Октябрь 13, 1878\n\n"),
                Text.literal("Карп\n").formatted(Formatting.BOLD),
                Text.literal( "- Отряд: Карпообразные\n"+
                        "- Распространение: Пресноводный\n"+
                        "- Может быть прокопчен")
        );
        builder.addPage(
                Text.literal("   Октябрь 13, 1878\n\n"),
                Text.literal("Деформированный карп\n").formatted(Formatting.BOLD),
                Text.literal("- Отряд: Карпообразные\n" +
                        "- Распространение: Пресноводный\n" +
                        "- Может быть прокопчен")
        );
        builder.addPage(
                Text.literal("   Октябрь 14, 1878\n\n"),
                Text.literal("Светящийся карп\n").formatted(Formatting.BOLD),
                Text.literal( "- Отряд: Карпообразные\n" +
                        "- Распространение: Пресноводный; Nocturnal\n" +
                        "- Может быть прокопчен\n" +
                        "- Специальные эффекты: Светится")
        );
        builder.addPage(
                Text.literal("   Октябрь 14, 1878\n\n"),
                Text.literal("Сом\n").formatted(Formatting.BOLD),
                Text.literal("- Отряд: Силуриформные\n" +
                        "- Распространение: Пресноводный\n"+
                        "- Может быть прокопчен")
        );
        builder.addPage(
                Text.literal("   Октябрь 16, 1878\n\n"),
                Text.literal("Грязный карп\n").formatted(Formatting.BOLD),
                Text.literal( "- Отряд: Силуриформные\n" +
                        "- Распространение: Мутные болотные воды\n" +
                        "- Может быть прокопчен")
        );
        builder.addPage(
                Text.literal("   Октябрь 24, 1878\n\n"),
                Text.literal("Тропический сом\n").formatted(Formatting.BOLD),
                Text.literal( "- Отряд: Силуриформные\n" +
                        "- Распространение: Тропические воды\n" +
                        "- Может быть прокопчен")
        );
        builder.addPage(
                Text.literal("   Ноябрь 8, 1878\n\n"),
                Text.literal("Божественный сом\n").formatted(Formatting.BOLD),
                Text.literal( "- Отряд: Силуриформные\n" +
                        "- Распространение: Пресноводный; редкий, но гораздо более распространенный во время дождя\n" +
                        "- Может быть прокопчен\n" +
                        "- Special effects: Ascension")
        );
        builder.addPage(
                Text.literal("   Ноябрь 22, 1878\n\n"),
                Text.literal("Скумбрия\n").formatted(Formatting.BOLD),
                Text.literal( "- Отряд: Перциформные\n" +
                        "- Распространение: Солёная вода\n"+
                        "- Может быть прокопчен")
        );
        builder.addPage(
                Text.literal("   Ноябрь 27, 1878\n\n"),
                Text.literal("Светящаяся скумбрия\n").formatted(Formatting.BOLD),
                Text.literal( "- Отряд: Перциформные\n" +
                        "- Распространение: Солёная вод; Ночной\n" +
                        "- Может быть прокопчен\n" +
                        "- Специальные эффекты: Светится")
        );
        builder.addPage(
                Text.literal("   Декабрь 1, 1878\n\n"),
                Text.literal("Мангровый каранк\n").formatted(Formatting.BOLD),
                Text.literal( "- Отряд: Перциформные\n" +
                        "- Распространение: Мангровые воды\n" +
                        "- Может быть прокопчен")
        );
        builder.addPage(
                Text.literal("   Декабрь 7, 1878\n\n"),
                Text.literal("Креветка\n").formatted(Formatting.BOLD),
                Text.literal( "- Отряд: Десятиногие\n" +
                        "- Распространение: Теплолюбивый; Морские воды\n"+
                        "- Может быть прокопчен")
        );
        builder.addPage(
                Text.literal("   Декабрь 14, 1878\n\n"),
                Text.literal("Светящаяся креветка\n").formatted(Formatting.BOLD),
                Text.literal("- Отряд: Десятиногие\n" +
                        "- Распространение: Теплолюбивый; Морские воды; Ночной\n"+
                        "- Может быть прокопчен\n"+
                        "- Специальные эффекты: Светится")
        );
        builder.addPage(
                Text.literal("   Декабрь 15, 1878\n\n"),
                Text.literal("Медуза\n").formatted(Formatting.BOLD),
                Text.literal("- Порядок: Семеостомовые\n" +
                        "- Распространение: Морские воды\n"+
                        "- Возможна аллергическая реакция")
        );
        builder.addPage(
                Text.literal("   Январь 7, 1879\n\n"),
                Text.literal("Божественная медуза\n").formatted(Formatting.BOLD),
                Text.literal("- Порядок: Семеостомовые\n" +
                        "- Распространение: Морские воды; редкий, но гораздо более распространенный во время дождя\n"+
                        "- Special effects: Ascension")
        );
        builder.addPage(
                Text.literal("   Январь 9, 1879\n\n"),
                Text.literal("Рыба-удильщик\n").formatted(Formatting.BOLD),
                Text.literal( "- Отряд: Лопоухие\n" +
                        "- Распространение: Абсолютная темнота в самых глубоких пещерах; чаще встречается в древних городах\n" +
                        "- Может быть прокопчен\n" +
                        "- Часто вызывает тошноту")
        );
        builder.addPage(
                Text.literal("   Март 30, 1879\n\n"),
                Text.literal("Красный кои\n").formatted(Formatting.BOLD),
                Text.literal( "- Отряд: Карпообразные\n" +
                        "- Распространение: Вишнёвые леса\n" +
                        "- Может быть прокопчен" )
        );
        builder.addPage(
                Text.literal("   Апрель 2, 1879\n\n"),
                Text.literal("Жёлтый кои\n").formatted(Formatting.BOLD),
                Text.literal( "- Отряд: Карпообразные\n" +
                        "- Распространение: Вишнёвые леса\n" +
                        "- Может быть прокопчен" )
        );
        builder.addPage(
                Text.literal("   Июнь 19, 1879\n\n"),
                Text.literal("Грозовик\n").formatted(Formatting.BOLD),
                Text.literal("- Отряд: Фульмениформные\n" +
                        "- Распространение: Наэлектризованные воды\n" +
                        "- При зарядке медью он, по-видимому, обладает некоторыми необычными свойствами" )
        );
        builder.addPage(
                Text.literal("   Илю 25, 1879\n\n"),
                Text.literal("Морская звезда\n").formatted(Formatting.BOLD),
                Text.literal("- Отряд: Паксиллозида\n" +
                        "- Распространение: Тёплые океаны и пляжи\n" +
                        "- Получается отличный шашлыкk" )
        );
        builder.addPage(
                Text.literal("   Июль 13, 1879\n\n"),
                Text.literal("Ледяная треска\n").formatted(Formatting.BOLD),
                Text.literal("- Отряд: Гадеобразные\n" +
                        "- Распространение: Найден под ледниками\n" +
                        "- Она ОЧЕНЬ холодная" )
        );
        builder.addPage(
                Text.literal("   Июль 19, 1879\n\n"),
                Text.literal("Солнечная рыба\n").formatted(Formatting.BOLD),
                Text.literal("- Отряд: Неизвестно\n" +
                        "- Распространение: Встречается в солнечные дни, в самых высокогорных районах страны\n" +
                        "- Странный вкус" )
        );
        builder.addPage(
                Text.literal("   Август 23, 1879\n\n"),
                Text.literal("Рыба-панда\n").formatted(Formatting.BOLD),
                Text.literal("- Отряд: Неизвестно\n" +
                        "- Распространение: Найдена в бамбуковых джунглях\n" +
                        "- Странный вкус" )
        );
        builder.addPage(
                Text.literal("   Сентябрь 15, 1879\n\n"),
                Text.literal("Рыба-ведьма\n").formatted(Formatting.BOLD),
                Text.literal("- Отряд: Неизвестно\n" +
                        "- Распространение: Встречается в районах, населенных грибами\n" +
                        "- Странный вкус" )
        );
        builder.addPage(
                Text.literal("   Ноябрь 9, 1879\n\n"),
                Text.literal("Рыба-цветок\n").formatted(Formatting.BOLD),
                Text.literal("- Отряд: Неизвестно\n" +
                        "- Распространение: Наёдена в цветочных лесах\n" +
                        "- Странный вкус" )
        );
        builder.addPage(
                Text.literal("   Июль XX, 19XX\n\n"),
                Text.literal("Эндер-медуза\n").formatted(Formatting.BOLD),
                Text.literal("- Порядок: Семеостомовые\n" +
                        "- Распространение: Хороший вопрос. Где, чёрт возьми, я?\n"+
                        "- Потенциальная аллергическая реакция")
        );
        builder.addPage(
                Text.literal("   Июль XX, 19XX\n\n"),
                Text.literal("Эндер-звезда\n").formatted(Formatting.BOLD),
                Text.literal("- Отряд: Паксиллозида\n" +
                        "- Распространение: Я начинаю беспокоиться...\n" +
                        "- Я не знаю, съедобно ли это, но я не буду рисковать" )
        );

        IndexGui.book = builder.asStack();
    }


    public static final class IndexGui extends BookGui {
        public static ItemStack book;
        private final ItemStack stack;
        private final Hand hand;

        public IndexGui(ServerPlayerEntity player, Hand hand) {
            super(player, book);
            this.stack = player.getStackInHand(hand);
            this.hand = hand;
            this.setPage(Math.min(stack.getOrCreateNbt().getInt("Page"), book.getNbt().getList("pages", NbtElement.STRING_TYPE).size() - 1));
        }

        @Override
        public void onOpen() {
            super.onOpen();
        }

        @Override
        public void onClose() {
            super.onClose();
        }

        @Override
        public void onTakeBookButton() {
            this.close();
        }

        @Override
        public void setPage(int page) {
            super.setPage(page);
            this.player.playSound(SoundEvents.ITEM_BOOK_PAGE_TURN, SoundCategory.BLOCKS, 1f, 1);

            if (this.stack == this.player.getStackInHand(hand)) {
                this.stack.getOrCreateNbt().putInt("Page", page);
            }
        }
    }
    public static final class FishGui extends BookGui {
        public static final Map<Identifier, ItemStack> BOOKS = new HashMap<>();
        private final Runnable runnable;
        private boolean forceReopen;

        public FishGui(ServerPlayerEntity player, Identifier identifier, boolean forceReopen, Runnable runnable) {
            super(player, BOOKS.get(identifier));
            this.runnable = runnable;
            this.forceReopen = forceReopen;
        }

        @Override
        public void setPage(int page) {
            super.setPage(page);
            this.player.playSound(SoundEvents.ITEM_BOOK_PAGE_TURN, SoundCategory.BLOCKS, 1f, 1);
        }

        @Override
        public void onTakeBookButton() {
            super.onTakeBookButton();
            this.close();
        }

        @Override
        public void onClose() {
            if (this.forceReopen) {
                this.open();
                this.forceReopen = false;
            } else {
                super.onClose();
                runnable.run();
            }
        }
    }
}
