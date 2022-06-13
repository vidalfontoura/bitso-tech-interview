package virtualmind.interview.project.date;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.LongStream;
import java.util.stream.Stream;

@lombok.Data
class DateBucket {
    final Instant from;
    final Instant to;

    public static List<DateBucket> bucketize(ZonedDateTime fromDate,
                                             ZonedDateTime toDate,
                                             int bucketSize,
                                             ChronoUnit bucketSizeUnit) {
        List<DateBucket> buckets = new ArrayList<>();
        boolean reachedDate = false;
        for (int i = 0; !reachedDate; i++) {
            ZonedDateTime minDate = fromDate.plus(i * bucketSize, bucketSizeUnit);
            ZonedDateTime maxDate = fromDate.plus((i + 1) * bucketSize, bucketSizeUnit);
            reachedDate = toDate.isBefore(maxDate);
            buckets.add(new DateBucket(minDate.toInstant(), maxDate.toInstant()));
        }
        return buckets;
    }
    public static List<DateBucket> bucketizeStream(ZonedDateTime fromDate,
                                             ZonedDateTime toDate,
                                             int bucketSize,
                                             ChronoUnit bucketSizeUnit) {

        return LongStream.range(0, bucketSizeUnit.between(fromDate, toDate)/bucketSize + 1)
                .mapToObj( nb -> new DateBucket(
                        fromDate.plus(nb * bucketSize, bucketSizeUnit).toInstant(),
                        fromDate.plus((nb+1) * bucketSize, bucketSizeUnit).toInstant()))
                .collect(Collectors.toList());

    }



    public static void main(String[] args) {

        List<DateBucket> list = DateBucket.bucketize(
                ZonedDateTime.of( 2020, 05,10, 16,00,00 , 00, ZoneId.systemDefault()),
                ZonedDateTime.of(2020, 05, 10, 18, 00, 00, 00, ZoneId.systemDefault()), 1,
                ChronoUnit.HOURS);

        for  (DateBucket d: list) {
            System.out.println(d.from + " -> " + d.to);
        }

        System.out.println();

        List<DateBucket> list2 = DateBucket.bucketizeStream( ZonedDateTime.of( 2020, 05,10, 16,00,00 , 00, ZoneId.systemDefault()),
                ZonedDateTime.of(2020, 05, 10, 18, 00, 00, 00, ZoneId.systemDefault()), 1,
                ChronoUnit.HOURS);


        for  (DateBucket d: list2) {
            System.out.println(d.from + " -> " + d.to);
        }


    }

    /**
     *   long step = bucketSizeUnit.getDuration().toMillis();
     * //        long from = fromDate.toInstant().toEpochMilli();
     * //        long to = toDate.toInstant().toEpochMilli();
     * //        int steps = (int) ((to - from) / (step * bucketSize));
     * //        return Stream.iterate(0, i -> Math.toIntExact(i + step))
     * //                .limit(steps)
     * //                .map(i -> new DateBucket(
     * //                fromDate.plus(i * bucketSize, bucketSizeUnit).toInstant(),
     * //                fromDate.plus((i + 1) * bucketSize, bucketSizeUnit).toInstant()
     * //        )).collect(Collectors.toList());
     */
}
