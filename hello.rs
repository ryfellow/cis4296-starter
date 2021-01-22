
fn main() {
    for i in 1..=10 {
        println!("{}! = {}", i, fact(i));
    }
}

fn fact(i: u32) -> u32 {
    (1..=i).product()
}
