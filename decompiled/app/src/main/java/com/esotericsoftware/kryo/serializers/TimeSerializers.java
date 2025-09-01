package com.esotericsoftware.kryo.serializers;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.KryoException;
import com.esotericsoftware.kryo.Serializer;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import com.esotericsoftware.kryo.util.Util;
import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.MonthDay;
import java.time.OffsetDateTime;
import java.time.OffsetTime;
import java.time.Period;
import java.time.Year;
import java.time.YearMonth;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import org.objectweb.asm.Opcodes;

/* loaded from: classes.dex */
public final class TimeSerializers {

    public static class DurationSerializer extends Serializer<Duration> {
        private DurationSerializer() {
            setImmutable(true);
        }

        @Override // com.esotericsoftware.kryo.Serializer
        public /* bridge */ /* synthetic */ Duration read(Kryo kryo, Input input, Class<Duration> cls) {
            return read2(kryo, input, cls);
        }

        @Override // com.esotericsoftware.kryo.Serializer
        public /* bridge */ /* synthetic */ void write(Kryo kryo, Output output, Duration duration) throws IOException, KryoException {
            write2(kryo, output, duration);
        }

        @Override // com.esotericsoftware.kryo.Serializer
        /* renamed from: read, reason: avoid collision after fix types in other method */
        public Duration read2(Kryo kryo, Input input, Class<Duration> cls) {
            return Duration.ofSeconds(input.readLong(), input.readInt(true));
        }

        /* renamed from: write, reason: avoid collision after fix types in other method */
        public void write2(Kryo kryo, Output output, Duration duration) throws IOException, KryoException {
            output.writeLong(duration.getSeconds());
            output.writeInt(duration.getNano(), true);
        }

        public /* synthetic */ DurationSerializer(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    public static class InstantSerializer extends Serializer<Instant> {
        private InstantSerializer() {
            setImmutable(true);
        }

        @Override // com.esotericsoftware.kryo.Serializer
        public /* bridge */ /* synthetic */ Instant read(Kryo kryo, Input input, Class<Instant> cls) {
            return read2(kryo, input, cls);
        }

        @Override // com.esotericsoftware.kryo.Serializer
        public /* bridge */ /* synthetic */ void write(Kryo kryo, Output output, Instant instant) throws KryoException {
            write2(kryo, output, instant);
        }

        @Override // com.esotericsoftware.kryo.Serializer
        /* renamed from: read, reason: avoid collision after fix types in other method */
        public Instant read2(Kryo kryo, Input input, Class<Instant> cls) {
            return Instant.ofEpochSecond(input.readLong(true), input.readInt(true));
        }

        /* renamed from: write, reason: avoid collision after fix types in other method */
        public void write2(Kryo kryo, Output output, Instant instant) throws KryoException {
            output.writeLong(instant.getEpochSecond(), true);
            output.writeInt(instant.getNano(), true);
        }

        public /* synthetic */ InstantSerializer(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    public static class LocalDateSerializer extends Serializer<LocalDate> {
        private LocalDateSerializer() {
            setImmutable(true);
        }

        @Override // com.esotericsoftware.kryo.Serializer
        public /* bridge */ /* synthetic */ LocalDate read(Kryo kryo, Input input, Class<LocalDate> cls) {
            return read2(kryo, input, cls);
        }

        @Override // com.esotericsoftware.kryo.Serializer
        public /* bridge */ /* synthetic */ void write(Kryo kryo, Output output, LocalDate localDate) throws IOException, KryoException {
            write2(kryo, output, localDate);
        }

        @Override // com.esotericsoftware.kryo.Serializer
        /* renamed from: read, reason: avoid collision after fix types in other method */
        public LocalDate read2(Kryo kryo, Input input, Class<LocalDate> cls) {
            return read(input);
        }

        /* renamed from: write, reason: avoid collision after fix types in other method */
        public void write2(Kryo kryo, Output output, LocalDate localDate) throws IOException, KryoException {
            write(output, localDate);
        }

        public /* synthetic */ LocalDateSerializer(AnonymousClass1 anonymousClass1) {
            this();
        }

        public static LocalDate read(Input input) {
            return LocalDate.of(input.readInt(true), input.readByte(), input.readByte());
        }

        public static void write(Output output, LocalDate localDate) throws IOException, KryoException {
            output.writeInt(localDate.getYear(), true);
            output.writeByte(localDate.getMonthValue());
            output.writeByte(localDate.getDayOfMonth());
        }
    }

    public static class LocalDateTimeSerializer extends Serializer<LocalDateTime> {
        private LocalDateTimeSerializer() {
            setImmutable(true);
        }

        @Override // com.esotericsoftware.kryo.Serializer
        public /* bridge */ /* synthetic */ LocalDateTime read(Kryo kryo, Input input, Class<LocalDateTime> cls) {
            return read2(kryo, input, cls);
        }

        @Override // com.esotericsoftware.kryo.Serializer
        public /* bridge */ /* synthetic */ void write(Kryo kryo, Output output, LocalDateTime localDateTime) throws IOException, KryoException {
            write2(kryo, output, localDateTime);
        }

        @Override // com.esotericsoftware.kryo.Serializer
        /* renamed from: read, reason: avoid collision after fix types in other method */
        public LocalDateTime read2(Kryo kryo, Input input, Class<LocalDateTime> cls) {
            return LocalDateTime.of(LocalDateSerializer.read(input), LocalTimeSerializer.read(input));
        }

        /* renamed from: write, reason: avoid collision after fix types in other method */
        public void write2(Kryo kryo, Output output, LocalDateTime localDateTime) throws IOException, KryoException {
            LocalDateSerializer.write(output, localDateTime.toLocalDate());
            LocalTimeSerializer.write(output, localDateTime.toLocalTime());
        }

        public /* synthetic */ LocalDateTimeSerializer(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    public static class LocalTimeSerializer extends Serializer<LocalTime> {
        private LocalTimeSerializer() {
            setImmutable(true);
        }

        @Override // com.esotericsoftware.kryo.Serializer
        public /* bridge */ /* synthetic */ LocalTime read(Kryo kryo, Input input, Class<LocalTime> cls) {
            return read2(kryo, input, cls);
        }

        @Override // com.esotericsoftware.kryo.Serializer
        public /* bridge */ /* synthetic */ void write(Kryo kryo, Output output, LocalTime localTime) throws IOException, KryoException {
            write2(kryo, output, localTime);
        }

        @Override // com.esotericsoftware.kryo.Serializer
        /* renamed from: read, reason: avoid collision after fix types in other method */
        public LocalTime read2(Kryo kryo, Input input, Class<LocalTime> cls) {
            return read(input);
        }

        /* renamed from: write, reason: avoid collision after fix types in other method */
        public void write2(Kryo kryo, Output output, LocalTime localTime) throws IOException, KryoException {
            write(output, localTime);
        }

        public /* synthetic */ LocalTimeSerializer(AnonymousClass1 anonymousClass1) {
            this();
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v3, types: [int] */
        public static LocalTime read(Input input) throws KryoException {
            int i;
            int i2;
            int i3 = input.readByte();
            byte b2 = 0;
            if (i3 >= 0) {
                byte b3 = input.readByte();
                if (b3 < 0) {
                    ?? r5 = ~b3;
                    i2 = 0;
                    b2 = r5;
                    i = 0;
                } else {
                    byte b4 = input.readByte();
                    if (b4 < 0) {
                        i = ~b4;
                        b2 = b3;
                    } else {
                        int i4 = input.readInt(true);
                        i = b4;
                        i2 = i4;
                        b2 = b3;
                    }
                }
                return LocalTime.of(i3, b2, i, i2);
            }
            i3 = ~i3;
            i = 0;
            i2 = 0;
            return LocalTime.of(i3, b2, i, i2);
        }

        public static void write(Output output, LocalTime localTime) throws IOException, KryoException {
            if (localTime.getNano() == 0) {
                if (localTime.getSecond() == 0) {
                    if (localTime.getMinute() == 0) {
                        output.writeByte(~localTime.getHour());
                        return;
                    } else {
                        output.writeByte(localTime.getHour());
                        output.writeByte(~localTime.getMinute());
                        return;
                    }
                }
                output.writeByte(localTime.getHour());
                output.writeByte(localTime.getMinute());
                output.writeByte(~localTime.getSecond());
                return;
            }
            output.writeByte(localTime.getHour());
            output.writeByte(localTime.getMinute());
            output.writeByte(localTime.getSecond());
            output.writeInt(localTime.getNano(), true);
        }
    }

    public static class MonthDaySerializer extends Serializer<MonthDay> {
        private MonthDaySerializer() {
            setImmutable(true);
        }

        @Override // com.esotericsoftware.kryo.Serializer
        public /* bridge */ /* synthetic */ MonthDay read(Kryo kryo, Input input, Class<MonthDay> cls) {
            return read2(kryo, input, cls);
        }

        @Override // com.esotericsoftware.kryo.Serializer
        public /* bridge */ /* synthetic */ void write(Kryo kryo, Output output, MonthDay monthDay) throws IOException, KryoException {
            write2(kryo, output, monthDay);
        }

        @Override // com.esotericsoftware.kryo.Serializer
        /* renamed from: read, reason: avoid collision after fix types in other method */
        public MonthDay read2(Kryo kryo, Input input, Class<MonthDay> cls) {
            return MonthDay.of(input.readByte(), input.readByte());
        }

        /* renamed from: write, reason: avoid collision after fix types in other method */
        public void write2(Kryo kryo, Output output, MonthDay monthDay) throws IOException, KryoException {
            output.writeByte(monthDay.getMonthValue());
            output.writeByte(monthDay.getDayOfMonth());
        }

        public /* synthetic */ MonthDaySerializer(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    public static class OffsetDateTimeSerializer extends Serializer<OffsetDateTime> {
        private OffsetDateTimeSerializer() {
            setImmutable(true);
        }

        @Override // com.esotericsoftware.kryo.Serializer
        public /* bridge */ /* synthetic */ OffsetDateTime read(Kryo kryo, Input input, Class<OffsetDateTime> cls) {
            return read2(kryo, input, cls);
        }

        @Override // com.esotericsoftware.kryo.Serializer
        public /* bridge */ /* synthetic */ void write(Kryo kryo, Output output, OffsetDateTime offsetDateTime) throws IOException, KryoException {
            write2(kryo, output, offsetDateTime);
        }

        @Override // com.esotericsoftware.kryo.Serializer
        /* renamed from: read, reason: avoid collision after fix types in other method */
        public OffsetDateTime read2(Kryo kryo, Input input, Class<OffsetDateTime> cls) {
            return OffsetDateTime.of(LocalDateSerializer.read(input), LocalTimeSerializer.read(input), ZoneOffsetSerializer.read(input));
        }

        /* renamed from: write, reason: avoid collision after fix types in other method */
        public void write2(Kryo kryo, Output output, OffsetDateTime offsetDateTime) throws IOException, KryoException {
            LocalDateSerializer.write(output, offsetDateTime.toLocalDate());
            LocalTimeSerializer.write(output, offsetDateTime.toLocalTime());
            ZoneOffsetSerializer.write(output, offsetDateTime.getOffset());
        }

        public /* synthetic */ OffsetDateTimeSerializer(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    public static class OffsetTimeSerializer extends Serializer<OffsetTime> {
        private OffsetTimeSerializer() {
            setImmutable(true);
        }

        @Override // com.esotericsoftware.kryo.Serializer
        public /* bridge */ /* synthetic */ OffsetTime read(Kryo kryo, Input input, Class<OffsetTime> cls) {
            return read2(kryo, input, cls);
        }

        @Override // com.esotericsoftware.kryo.Serializer
        public /* bridge */ /* synthetic */ void write(Kryo kryo, Output output, OffsetTime offsetTime) throws IOException, KryoException {
            write2(kryo, output, offsetTime);
        }

        @Override // com.esotericsoftware.kryo.Serializer
        /* renamed from: read, reason: avoid collision after fix types in other method */
        public OffsetTime read2(Kryo kryo, Input input, Class<OffsetTime> cls) {
            return OffsetTime.of(LocalTimeSerializer.read(input), ZoneOffsetSerializer.read(input));
        }

        /* renamed from: write, reason: avoid collision after fix types in other method */
        public void write2(Kryo kryo, Output output, OffsetTime offsetTime) throws IOException, KryoException {
            LocalTimeSerializer.write(output, offsetTime.toLocalTime());
            ZoneOffsetSerializer.write(output, offsetTime.getOffset());
        }

        public /* synthetic */ OffsetTimeSerializer(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    public static class PeriodSerializer extends Serializer<Period> {
        private PeriodSerializer() {
            setImmutable(true);
        }

        @Override // com.esotericsoftware.kryo.Serializer
        public /* bridge */ /* synthetic */ Period read(Kryo kryo, Input input, Class<Period> cls) {
            return read2(kryo, input, cls);
        }

        @Override // com.esotericsoftware.kryo.Serializer
        public /* bridge */ /* synthetic */ void write(Kryo kryo, Output output, Period period) throws KryoException {
            write2(kryo, output, period);
        }

        @Override // com.esotericsoftware.kryo.Serializer
        /* renamed from: read, reason: avoid collision after fix types in other method */
        public Period read2(Kryo kryo, Input input, Class<Period> cls) {
            return Period.of(input.readInt(true), input.readInt(true), input.readInt(true));
        }

        /* renamed from: write, reason: avoid collision after fix types in other method */
        public void write2(Kryo kryo, Output output, Period period) throws KryoException {
            output.writeInt(period.getYears(), true);
            output.writeInt(period.getMonths(), true);
            output.writeInt(period.getDays(), true);
        }

        public /* synthetic */ PeriodSerializer(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    public static class YearMonthSerializer extends Serializer<YearMonth> {
        private YearMonthSerializer() {
            setImmutable(true);
        }

        @Override // com.esotericsoftware.kryo.Serializer
        public /* bridge */ /* synthetic */ YearMonth read(Kryo kryo, Input input, Class<YearMonth> cls) {
            return read2(kryo, input, cls);
        }

        @Override // com.esotericsoftware.kryo.Serializer
        public /* bridge */ /* synthetic */ void write(Kryo kryo, Output output, YearMonth yearMonth) throws IOException, KryoException {
            write2(kryo, output, yearMonth);
        }

        @Override // com.esotericsoftware.kryo.Serializer
        /* renamed from: read, reason: avoid collision after fix types in other method */
        public YearMonth read2(Kryo kryo, Input input, Class<YearMonth> cls) {
            return YearMonth.of(input.readInt(true), input.readByte());
        }

        /* renamed from: write, reason: avoid collision after fix types in other method */
        public void write2(Kryo kryo, Output output, YearMonth yearMonth) throws IOException, KryoException {
            output.writeInt(yearMonth.getYear(), true);
            output.writeByte(yearMonth.getMonthValue());
        }

        public /* synthetic */ YearMonthSerializer(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    public static class YearSerializer extends Serializer<Year> {
        private YearSerializer() {
            setImmutable(true);
        }

        @Override // com.esotericsoftware.kryo.Serializer
        public /* bridge */ /* synthetic */ Year read(Kryo kryo, Input input, Class<Year> cls) {
            return read2(kryo, input, cls);
        }

        @Override // com.esotericsoftware.kryo.Serializer
        public /* bridge */ /* synthetic */ void write(Kryo kryo, Output output, Year year) throws KryoException {
            write2(kryo, output, year);
        }

        @Override // com.esotericsoftware.kryo.Serializer
        /* renamed from: read, reason: avoid collision after fix types in other method */
        public Year read2(Kryo kryo, Input input, Class<Year> cls) {
            return Year.of(input.readInt(true));
        }

        /* renamed from: write, reason: avoid collision after fix types in other method */
        public void write2(Kryo kryo, Output output, Year year) throws KryoException {
            output.writeInt(year.getValue(), true);
        }

        public /* synthetic */ YearSerializer(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    public static class ZoneIdSerializer extends Serializer<ZoneId> {
        private ZoneIdSerializer() {
            setImmutable(true);
        }

        @Override // com.esotericsoftware.kryo.Serializer
        public /* bridge */ /* synthetic */ ZoneId read(Kryo kryo, Input input, Class<ZoneId> cls) {
            return read2(kryo, input, cls);
        }

        @Override // com.esotericsoftware.kryo.Serializer
        public /* bridge */ /* synthetic */ void write(Kryo kryo, Output output, ZoneId zoneId) throws IOException, KryoException {
            write2(kryo, output, zoneId);
        }

        @Override // com.esotericsoftware.kryo.Serializer
        /* renamed from: read, reason: avoid collision after fix types in other method */
        public ZoneId read2(Kryo kryo, Input input, Class<ZoneId> cls) {
            return read(input);
        }

        /* renamed from: write, reason: avoid collision after fix types in other method */
        public void write2(Kryo kryo, Output output, ZoneId zoneId) throws IOException, KryoException {
            write(output, zoneId);
        }

        public /* synthetic */ ZoneIdSerializer(AnonymousClass1 anonymousClass1) {
            this();
        }

        public static ZoneId read(Input input) {
            return ZoneId.of(input.readString());
        }

        public static void write(Output output, ZoneId zoneId) throws IOException, KryoException {
            output.writeString(zoneId.getId());
        }
    }

    public static class ZoneOffsetSerializer extends Serializer<ZoneOffset> {
        private ZoneOffsetSerializer() {
            setImmutable(true);
        }

        @Override // com.esotericsoftware.kryo.Serializer
        public /* bridge */ /* synthetic */ ZoneOffset read(Kryo kryo, Input input, Class<ZoneOffset> cls) {
            return read2(kryo, input, cls);
        }

        @Override // com.esotericsoftware.kryo.Serializer
        public /* bridge */ /* synthetic */ void write(Kryo kryo, Output output, ZoneOffset zoneOffset) throws IOException, KryoException {
            write2(kryo, output, zoneOffset);
        }

        @Override // com.esotericsoftware.kryo.Serializer
        /* renamed from: read, reason: avoid collision after fix types in other method */
        public ZoneOffset read2(Kryo kryo, Input input, Class<ZoneOffset> cls) {
            return read(input);
        }

        /* renamed from: write, reason: avoid collision after fix types in other method */
        public void write2(Kryo kryo, Output output, ZoneOffset zoneOffset) throws IOException, KryoException {
            write(output, zoneOffset);
        }

        public /* synthetic */ ZoneOffsetSerializer(AnonymousClass1 anonymousClass1) {
            this();
        }

        public static ZoneOffset read(Input input) throws KryoException {
            byte b2 = input.readByte();
            return b2 == 127 ? ZoneOffset.ofTotalSeconds(input.readInt()) : ZoneOffset.ofTotalSeconds(b2 * 900);
        }

        public static void write(Output output, ZoneOffset zoneOffset) throws IOException, KryoException {
            int totalSeconds = zoneOffset.getTotalSeconds();
            int i = totalSeconds % 900 == 0 ? totalSeconds / 900 : Opcodes.LAND;
            output.writeByte(i);
            if (i == 127) {
                output.writeInt(totalSeconds);
            }
        }
    }

    public static class ZonedDateTimeSerializer extends Serializer<ZonedDateTime> {
        private ZonedDateTimeSerializer() {
            setImmutable(true);
        }

        @Override // com.esotericsoftware.kryo.Serializer
        public /* bridge */ /* synthetic */ ZonedDateTime read(Kryo kryo, Input input, Class<ZonedDateTime> cls) {
            return read2(kryo, input, cls);
        }

        @Override // com.esotericsoftware.kryo.Serializer
        public /* bridge */ /* synthetic */ void write(Kryo kryo, Output output, ZonedDateTime zonedDateTime) throws IOException, KryoException {
            write2(kryo, output, zonedDateTime);
        }

        @Override // com.esotericsoftware.kryo.Serializer
        /* renamed from: read, reason: avoid collision after fix types in other method */
        public ZonedDateTime read2(Kryo kryo, Input input, Class<ZonedDateTime> cls) {
            return ZonedDateTime.of(LocalDateSerializer.read(input), LocalTimeSerializer.read(input), ZoneIdSerializer.read(input));
        }

        /* renamed from: write, reason: avoid collision after fix types in other method */
        public void write2(Kryo kryo, Output output, ZonedDateTime zonedDateTime) throws IOException, KryoException {
            LocalDateSerializer.write(output, zonedDateTime.toLocalDate());
            LocalTimeSerializer.write(output, zonedDateTime.toLocalTime());
            ZoneIdSerializer.write(output, zonedDateTime.getZone());
        }

        public /* synthetic */ ZonedDateTimeSerializer(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    public static void addDefaultSerializers(Kryo kryo) {
        if (Util.isClassAvailable("java.time.Duration")) {
            kryo.addDefaultSerializer(Duration.class, new DurationSerializer(null));
        }
        if (Util.isClassAvailable("java.time.Instant")) {
            kryo.addDefaultSerializer(Instant.class, new InstantSerializer(null));
        }
        if (Util.isClassAvailable("java.time.LocalDate")) {
            kryo.addDefaultSerializer(LocalDate.class, new LocalDateSerializer(null));
        }
        if (Util.isClassAvailable("java.time.LocalTime")) {
            kryo.addDefaultSerializer(LocalTime.class, new LocalTimeSerializer(null));
        }
        if (Util.isClassAvailable("java.time.LocalDateTime")) {
            kryo.addDefaultSerializer(LocalDateTime.class, new LocalDateTimeSerializer(null));
        }
        if (Util.isClassAvailable("java.time.ZoneOffset")) {
            kryo.addDefaultSerializer(ZoneOffset.class, new ZoneOffsetSerializer(null));
        }
        if (Util.isClassAvailable("java.time.ZoneId")) {
            kryo.addDefaultSerializer(ZoneId.class, new ZoneIdSerializer(null));
        }
        if (Util.isClassAvailable("java.time.OffsetTime")) {
            kryo.addDefaultSerializer(OffsetTime.class, new OffsetTimeSerializer(null));
        }
        if (Util.isClassAvailable("java.time.OffsetDateTime")) {
            kryo.addDefaultSerializer(OffsetDateTime.class, new OffsetDateTimeSerializer(null));
        }
        if (Util.isClassAvailable("java.time.ZonedDateTime")) {
            kryo.addDefaultSerializer(ZonedDateTime.class, new ZonedDateTimeSerializer(null));
        }
        if (Util.isClassAvailable("java.time.Year")) {
            kryo.addDefaultSerializer(Year.class, new YearSerializer(null));
        }
        if (Util.isClassAvailable("java.time.YearMonth")) {
            kryo.addDefaultSerializer(YearMonth.class, new YearMonthSerializer(null));
        }
        if (Util.isClassAvailable("java.time.MonthDay")) {
            kryo.addDefaultSerializer(MonthDay.class, new MonthDaySerializer(null));
        }
        if (Util.isClassAvailable("java.time.Period")) {
            kryo.addDefaultSerializer(Period.class, new PeriodSerializer(null));
        }
    }
}
