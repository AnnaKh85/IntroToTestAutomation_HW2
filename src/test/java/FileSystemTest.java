import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.example.File;
import org.example.Directory;

public class FileSystemTest {
    @Test
    void testFile() {
        File file = new File(50);
        assertEquals(50, file.getSize());
    }

    @ParameterizedTest
    @CsvSource({"100, 200, 300, 600", "50, 75, 100, 225"})
    void testDirectory(int size1, int size2, int size3, int expectedTotalSize) {
        Directory directory = new Directory();
        directory.add(new File(size1));
        directory.add(new File(size2));
        directory.add(new File(size3));

        assertEquals(expectedTotalSize, directory.getSize());
    }

    @Test
    void testNestedDirectories() {
        Directory root = new Directory();
        Directory folder1 = new Directory();
        Directory folder2 = new Directory();
        File file1 = new File(100);
        File file2 = new File(200);
        File file3 = new File(300);

        folder1.add(file1);
        folder1.add(file2);
        folder2.add(file3);
        root.add(folder1);
        root.add(folder2);

        assertEquals(600, root.getSize());
    }
}
